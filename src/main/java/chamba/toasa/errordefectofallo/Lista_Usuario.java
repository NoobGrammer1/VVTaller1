package chamba.toasa.errordefectofallo;
import java.util.ArrayList;
public class Lista_Usuario {
    private ArrayList <Usuario> listUsers;

    public Lista_Usuario() {
        this.listUsers = new ArrayList<Usuario>();
    }

    public void initUser(){
        try {
            Usuario usuario0 = new Usuario ("Anthony", "123456");
            Usuario usuario1 = new Usuario ("Mike", "12345");
            Usuario usuario2 = new Usuario ("Luis", "1234");
            Usuario usuario3 = new Usuario ("Isai", "123457");
            Usuario usuario4 = new Usuario ("Kevin", "123458");
            Usuario usuario5 = new Usuario ("Kelvin", "123459");
            this.listUsers.add(usuario0);
            this.listUsers.add(usuario1);
            this.listUsers.add(usuario2);
            this.listUsers.add(usuario3);
            this.listUsers.add(usuario4);
            this.listUsers.add(usuario5);
        }catch(ExceptionInInitializerError e){
            System.out.println("Error al inicializar" + e);
        }
    }

    public boolean verificarUsuario(Usuario user){
        try{
            for (int i = 0; i<this.listUsers.size(); i++){
                if (this.listUsers.get(i).getUsuario().equals(user.getUsuario()) &&
                        this.listUsers.get(i).getPassword().equals(user.getPassword())){
                    return true;
                }
            }
        }catch(ExceptionInInitializerError e){
            System.out.println("Error del sistema" + e);
        }
        return false;
    }

    public ArrayList<Usuario> getListUsers() {
        return listUsers;
    }

    public void setListUsers(ArrayList<Usuario> listUsers) {
        this.listUsers = listUsers;
    }

}
