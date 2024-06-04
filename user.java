import java.io.Serializable;

class User implements Serializable{
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    //Getters and Setters 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //checks
    boolean matchName(User u){
        return this.name.equals(u.getName());
    }
    boolean matchPassword(User u){
        return this.password.equals(u.getPassword());
    }

}