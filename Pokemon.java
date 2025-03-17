import java.util.List;

public class Pokemon {
    private String nombre;
    private String tipo1;
    private String tipo2;
    private int total;
    private int hp;
    private int ataque;
    private int defensa;
    private int spAtaque;
    private int spDefensa;
    private int velocidad;
    private List<String> habilidades;

    //Constructor
    public Pokemon(String nombre, String tipo1, String tipo2, int total, int hp, int ataque, int defensa, int spAtaque, int spDefensa, int velocidad, List<String> habilidades){
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.total = total;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.spAtaque = spAtaque;
        this.spDefensa = spDefensa;
        this.velocidad = velocidad;
        this.habilidades = habilidades;
    }

    //Sets y Gets
    public String getNombre() {
        return nombre;
    }
    
    public String getTipo1() {
        return tipo1;
    }
    
    public String getTipo2() {
        return tipo2;
    }
    
    public int getTotal() {
        return total;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    public int getDefensa() {
        return defensa;
    }
    
    public int getSpAtaque() {
        return spAtaque;
    }
    
    public int getSpDefensa() {
        return spDefensa;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString(){
        return "Pokemon{ " +
        "nombre ='" + nombre + '\'' +
                ", type1='" + tipo1 + '\'' +
                ", type2='" + tipo2 + '\'' +
                ", total=" + total +
                ", hp=" + hp +
                ", attack=" + ataque +
                ", defense=" + ataque +
                ", spAttack=" + spAtaque +
                ", spDefense=" + spDefensa +
                ", speed=" + velocidad +
                ", abilities=" + habilidades +
                '}';
    }
}