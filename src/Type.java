public enum Type implements java.lang.reflect.Type {
    WORK(0),
    PERSONAL(1);

public final int taskType;

    Type(int taskType) {
        this.taskType = taskType;
    }

    @Override
    public String getTypeName() {
        return java.lang.reflect.Type.super.getTypeName();
    }
}