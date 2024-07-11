package co.base.project.usecase.transversal.constants;

public final class ErrorsMessagesValidator {


    public static final String BUYER_EMAIL_IS_NOT_NULL = "El campo Buyer Email es obligatorio";
    public static final String LATITUDE_IS_NOT_NULL = "El campo Latitud es obligatoria";
    public static final String LONGITUDE_IS_NOT_NULL = "El campo Longitud es obligatoria";

    public static final String DAY_OF_TASK_NOT_NULL = "La propiedad dayOfTask es obligatoria";
    public static final String DAY_OF_TASK_MUST_BE_POSITIVE = "La propiedad dayOfTask solo recibe n\u00fameros mayores a cero";
    public static final String NAME_OF_TASK_NOT_NULL_OR_EMPTY = "La propiedad nameOfTask no puede ser vac\u00eda";
    public static final String ID_NOT_NULL_OR_EMPTY = "El id es un campo obligatorio";

    private ErrorsMessagesValidator() {
        super();
    }

}
