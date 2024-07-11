package co.base.project.usecase.transversal.enums;

public enum UseCaseEnum {

    GENERIC("generic", 0),
    GET_NOTIFICATION("getNotification", 1),
    SAVE_TASK("getNotification", 1),
    DELETE_TASK("deleteTask", 2);

    private final String useCaseName;
    private final int useCaseCode;

    UseCaseEnum(String useCaseName, int useCaseCode) {
        this.useCaseName = useCaseName;
        this.useCaseCode = useCaseCode;
    }

    public String getUseCaseName() {
        return useCaseName.concat("UseCase");
    }

    public int getUseCaseCode() {
        return useCaseCode;
    }
}
