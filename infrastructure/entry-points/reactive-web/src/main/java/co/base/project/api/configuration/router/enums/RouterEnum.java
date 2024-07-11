package co.base.project.api.configuration.router.enums;

public enum RouterEnum {

    TASK("/task"),
    NOTIFICATION("/buyer/notification")
    ;

    private String route;

    RouterEnum(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }

}
