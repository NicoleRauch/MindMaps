public class BacklogItem extends Entity {
    
    private SprintId sprintId;
    private BacklogItemStatusType status;
    ...
    
    public void commitTo(Sprint aSprint) {
        if (!this.isScheduledForRelease()) {
            throw new IllegalStateException(
                "Must be scheduled for release to commit to sprint.");
        }
        
        if (this.isCommittedToSprint()) {
            if (!aSprint.sprintId().equals(this.sprintId())) {
                this.uncommitFromSprint();
            }
        }
        
        this.elevateStatusWith(BacklogItemStatus.COMMITTED);
        
        this.setSprintId(aSprint.sprintId());
        
        DomainEventPublisher.instance()
            .publish(new BacklogItemCommitted(this.tenant(), this.backlogItemId(), this.sprintId()));
    }
    ... 
}


// client commits the backlog item to a sprint
// by using a domain-specific behavior

backlogItem.commitTo(sprint);

