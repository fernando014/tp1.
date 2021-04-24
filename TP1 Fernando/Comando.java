
public class Comando {
    private final String nome;
    private String descri;
    private Option[] option;
    private int numeroOps;

    public Comando(String var1, int var2) {
        this.nome = var1;
        this.numeroOps = var2;
        this.option = new Option[var2];
    }

    public Comando(String var1, String var2, int var3) {
        this.nome = var1;
        this.numeroOps = var3;
        this.option = new Option[var3];
        this.descri = var2;
    }

    public Comando(String var1) {
        this.nome = var1;
    }

    public Comando(String var1, String var2) {
        this.nome = var1;
        this.descri = var2;
    }

    public Comando(String var1, String var2, String var3, String var4, boolean var5) {
        this.option = new Option[1];
        this.nome = var1;
        this.descri = var2;
        System.out.println("tituloOp = " + var3);
        this.option[0] = new Option(var3, var4, var5);
    }

    public String getDescri() {
        return this.descri;
    }

    public void setDescri(String var1) {
        this.descri = var1;
    }

    public Option[] getOption() {
        return this.option;
    }

    public void setOption(Option[] var1) {
        this.option = var1;
    }

    public int getNumeroOps() {
        return this.numeroOps;
    }

    public void setNumeroOps(int var1) {
        this.numeroOps = var1;
    }

    public String getNome() {
        return this.nome;
    }

    public void help() {
        StringBuilder var1 = new StringBuilder();
        var1.append("Comando " + this.nome + "\n");
        var1.append("OpÃ§Ãµes: '\n'");
        Option[] var2 = this.option;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Option var5 = var2[var4];
            String var10001 = var5.getTitle();
            var1.append("\t" + var10001 + " " + var5.getDescr() + "\n");
        }

    }
}
