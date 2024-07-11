package co.base.project.usecase.transversal.enums;

public enum ApplicationCodesEnum {

    UNCHECKED_ERROR("0", UseCaseEnum.GENERIC, "Tuvimos un problema interno, por favor intenta mas tarde", 500),
    INVALID_REQUEST_OBJECT("1", UseCaseEnum.GENERIC, "Datos de entrada no v\u00e1lidos", 400),
    DEBES_ENVIAR_UN_CUERPO_DE_SOLICITUD_PARA_EL_CONSUMO_DE_ESTE_SERVICIO("2", UseCaseEnum.GENERIC, "Debes enviar un cuerpo de solicitud para el consumo de este servicio", 400),
    NO_SE_PUDO_CONSUMIR_SERVICIO_POR("3", UseCaseEnum.GENERIC, "No se pudo consumir servicio por -> ", 500),
    INVALID_DAY_OF_PROOF("4", UseCaseEnum.SAVE_TASK, "Debe ingresar un d\u00eda v\u00e1lido", 400),
    NO_PUDIMOS_BORRAR_LA_TAREA_PORQUE_NO_FUE_ENCONTRADA("5", UseCaseEnum.DELETE_TASK, "No pudimos borrar la tarea, porque no fue encontrada", 400),
    NO_SE_PUDO_CONSUMIR_SERVICIO_WEATHER("5", UseCaseEnum.GENERIC, "No se pudo obtener consumir el servicio de Weather API", 400),
    NOTIFICATION_NOT_FOUND("6", UseCaseEnum.GET_NOTIFICATION, "No se encontraron notificaciones para el usuario seleccionado", 400);


    public static final String SEPARATOR = "-";

    private final String errorCode;
    private final UseCaseEnum useCase;
    private final String message;
    private final int  statusCode;

    ApplicationCodesEnum(String errorCode, UseCaseEnum useCase, String message, int statusCode) {
        this.errorCode = errorCode;
        this.useCase = useCase;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return new StringBuilder()
                .append(useCase.getUseCaseCode())
                .append(SEPARATOR)
                .append(errorCode)
                .append(SEPARATOR)
                .append(statusCode)
                .toString();
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
