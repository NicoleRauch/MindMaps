public class BacklogItem extends Entity {
    private SprintId sprintId;
    private BacklogItemStatusType status;
    ...
    
    public void setSprintId(SprintId sprintId) {
        this.sprintId = sprintId;
    }
    public void setStatus(BacklogItemStatusType status) {
        this.status = status;
    }
    ... 
}




// client commits the backlog item to a sprint
// by setting its sprintId and status

backlogItem.setSprintId(sprintId);
backlogItem.setStatus(BacklogItemStatusType.COMMITTED);

