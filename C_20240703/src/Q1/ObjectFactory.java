package Q1;

public class ObjectFactory {
    public Object createObject(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("Apple")) {
            return new AppleClass();
        } else if (type.equalsIgnoreCase("Banana")) {
            return new BananaClass();
        } else if (type.equalsIgnoreCase("Ice")) {
            return new IceClass();
        }
        return null;
    }
}


