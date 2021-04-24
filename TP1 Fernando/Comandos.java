
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.Iterator;

public class Comandos {
    private ArrayList<Comando> lista = new ArrayList();

    public Comandos() {
    }

    public Comandos(Comando[] var1) {
        for(int var2 = 0; var2 < var1.length; ++var2) {
            this.lista.add(var1[var2]);
        }

    }

    public void adicionar(Comando var1) {
        this.lista.add(var1);
    }

    public boolean validar() {
        return false;
    }

    public ArrayList<Comando> getLista() {
        return this.lista;
    }

    public void showHelp() {
        System.out.println("TP1 - Lista de comandos vÃ¡lidos:");
        Iterator var1 = this.lista.iterator();

        while(var1.hasNext()) {
            Comando var2 = (Comando)var1.next();
            PrintStream var10000 = System.out;
            String var10001 = var2.getNome();
            var10000.println("\t" + var10001 + " :- " + var2.getDescri());
        }

        System.out.println("pressionar enter para ccntinuar ... ");
        Le.umChar();
    }
}
