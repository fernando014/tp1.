import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

 public class TP1 {
    private static MyCommand interC;
    static final int MAX_ALUNOS = 35;
    private static int alunosLidos = 0;
    private static int notaMax = 0;
    private static int notaMin = 0;
    private static int notaAvg = 0;
    private static String[] nomeAlunos = new String[35];
    private static int[] notasAlunos = new int[35];

    public TP1() {
    }
    public static void main(String[] var0) {
        boolean var1 = false;
        interC = new MyCommand();

        do {
            interC.limparEcra();
            interC.showPrompt();
            String[] var2 = interC.lerComando();
            ArrayList var3 = interC.validarComando(var2);
            if (var3 == null) {
                interC.showMsg("Comando invalido. Digite help para obter ajuda");
            } else if (((String)var3.get(0)).equalsIgnoreCase("carregar")) {
                alunosLidos = loadData(nomeAlunos, "turmaLeit.txt");
                int var4 = loadData(notasAlunos);
                if (alunosLidos != var4) {
                    System.out.println("alunos = " + alunosLidos);
                    System.out.println("notaA = " + var4);
                    interC.showMsg("Erro carregando dados");
                } else {
                    interC.showMsg("Dados carregados OK!");
                }
            } else if (((String)var3.get(0)).equalsIgnoreCase("listar")) {
                mostrarAlunos();
            } else {
                int var5;
                String var6;
                if (((String)var3.get(0)).equalsIgnoreCase("paginar")) {
                    var6 = JOptionPane.showInputDialog("NÅ©meros estudantes por pÃ£gina :");
                    var5 = Integer.parseInt(var6);
                    mostrarAlunos(var5);
                } else if (((String)var3.get(0)).equalsIgnoreCase("mostrarp")) {
                    mostrarPauta();
                } else if (((String)var3.get(0)).equalsIgnoreCase("mostrarr")) {
                    mostraResumo();
                } else if (((String)var3.get(0)).equalsIgnoreCase("top")) {
                    mostrarTop();
                } else if (((String)var3.get(0)).equalsIgnoreCase("pesquisarnome")) {
                    var6 = JOptionPane.showInputDialog("O que procura  :");
                    pesquisar(var6);
                } else if (((String)var3.get(0)).equalsIgnoreCase("pesquisarnota")) {
                    var6 = JOptionPane.showInputDialog("O que procura  :");
                    var5 = Integer.parseInt(var6);
                    pesquisar(var5);
                } else if (((String)var3.get(0)).equalsIgnoreCase("help")) {
                    interC.showHelp();
                } else if (((String)var3.get(0)).equalsIgnoreCase("terminar")) {
                    var1 = true;
                }
            }
        } while(!var1);

    }
    public static int loadData(String[] var0, String var1) {
        Scanner var2 = null;
        File var3 = new File(var1);

        try {
            var2 = new Scanner(var3);
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        }

        int var4 = 0;

        while(var2.hasNextLine()) {
            String var5 = var2.nextLine();
            if (var5 != null && !var5.isBlank() && !var5.isEmpty()) {
                var0[var4] = var5;
                ++var4;
            }
        }

        var2.close();
        return var4;
    }

    public static int loadData(int[] var0) {
        Random var1 = new Random();
        boolean var2 = false;

        int var4;
        for(var4 = 0; var4 < alunosLidos; ++var4) {
            int var3 = var1.nextInt(20) + 1;
            notasAlunos[var4] = var3;
        }

        return var4;
    }
    public static void mostrarAlunos() {
        int var0 = 0;
        if (nomeAlunos[0] != null) {
            String[] var1 = nomeAlunos;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                String var4 = var1[var3];
                if (var4 == null) {
                    break;
                }

                ++var0;
                System.out.println(var0 + "--" + var4);
            }

            interC.showMsg("");
        } else {
            interC.showMsg("Nao ha dados");
        }

    }

    public static void mostrarAlunos(int var0) {
        if (nomeAlunos[0] != null) {
            if (var0 > 0) {
                int var1 = 0;
                int var2 = 1;
                System.out.println("-----------Pagina " + var2 + "-----------");
                String[] var3 = nomeAlunos;
                int var4 = var3.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String var6 = var3[var5];
                    if (var6 == null) {
                        break;
                    }

                    ++var1;
                    System.out.println(var1 + "--" + var6);
                    if (var1 >= var0) {
                        interC.showMsg("\nEnter para proxima pagina");
                        System.out.println("\n\n");
                        ++var2;
                        System.out.println("-----------Pagina " + var2 + "-----------");
                        var1 = 0;
                    }
                }

                interC.showMsg("");
            }
        } else {
            interC.showMsg("Nao ha dados");
        }

    }

     private static void calcularMaxMinAvg() {
        if (nomeAlunos[0] != null) {
            notaMax = notasAlunos[0];
            notaMin = notasAlunos[0];
            int var0 = 0;
            int var1 = 0;
            int[] var2 = notasAlunos;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                int var5 = var2[var4];
                if (var5 > notaMax) {
                    notaMax = var5;
                }
                if (var5 < notaMin) {
                    notaMin = var5;
                }
                ++var0;
                var1 += var5;
            }

            notaAvg = var1 / var0;
        } else {
            interC.showMsg("Nao ha dados");
        }

     }

    public static void mostraResumo() {
        if (nomeAlunos[0] != null) {
            calcularMaxMinAvg();
            System.out.println("\n----------Resumo----------");
            System.out.println("Nota maxima: " + notaMax);
            System.out.println("Nota minima: " + notaMin);
            System.out.println("Nota media: " + notaAvg);
            int var0 = 0;
            int var1 = 0;

            for(int var2 = 0; nomeAlunos[var2] != null; ++var2) {
                if (notasAlunos[var2] > notaAvg) {
                    ++var0;
                }

                if (notasAlunos[var2] < notaAvg) {
                    ++var1;
                }
            }

            System.out.println("Numero de alunos com nota superior a media: " + var0);
            System.out.println("Numero de alunos com nota inferior a media: " + var1);
            interC.showMsg("");
        } else {
            interC.showMsg("Nao ha dados");
        }

    }

    public static void mostrarTop() {
        if (nomeAlunos[0] != null) {
            int var0 = 20;
            int var1 = 0;
            int var2 = 3;
            System.out.println("Alunos que tem as melhores notas:");

            for(; var2 > 0; ++var1) {
                if (var1 >= notasAlunos.length) {
                    var1 = 0;
                    --var0;
                }

                if (notasAlunos[var1] == var0) {
                    String var10001 = nomeAlunos[var1 - 1];
                    System.out.println(var10001 + "--" + notasAlunos[var1]);
                    --var2;
                }
            }

            interC.showMsg("");
        } else {
            interC.showMsg("Nao ha dados");
        }

    }

    public static void mostrarPauta() {
        int var0 = 0;
        if (nomeAlunos[0] != null) {
            System.out.println("Numero--------------Nome----------nota");
            String[] var1 = nomeAlunos;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                String var4 = var1[var3];
                if (var4 == null) {
                    break;
                }

                ++var0;
                System.out.println(var0 + "__" + var4 + "-----" + notasAlunos[var0]);
            }

            interC.showMsg("");
        } else {
            interC.showMsg("Nao ha dados");
        }

    }

    public static void mostrarDetalhesAluno(String var0) {
        interC.showMsg("A ser implementado ...");
    }
    public static void pesquisar(String var0) {
        if (nomeAlunos[0] != null) {
            boolean var1 = false;
            System.out.println("\n");
            String[] var2 = nomeAlunos;
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String var5 = var2[var4];
                if (var5 != null && var0.length() > 3) {
                    String[] var7 = var5.split(" ");
                    if (!var0.equalsIgnoreCase(var7[0]) && !var0.equalsIgnoreCase(var7[var7.length - 1])) {
                        if (var0.substring(0, 3).equalsIgnoreCase(var7[0].substring(0, 3)) || var0.substring(0, 3).equalsIgnoreCase(var7[var7.length - 1].substring(0, 3))) {
                            System.out.println("Nome parecido com " + var0 + ": " + var5);
                            var1 = true;
                        }
                    } else {
                        System.out.println("->" + var5);
                        var1 = true;
                    }
                }
            }
            if (!var1) {
                interC.showMsg("Nao encontrado");
            } else {
                interC.showMsg("");
            }
        } else {
            interC.showMsg("Nao ha dados");
        }

    }
    public static void pesquisar(int var0) {
        if (nomeAlunos[0] != null) {
            boolean var1 = false;
            int var2 = -1;
            int[] var3 = notasAlunos;
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                int var6 = var3[var5];
                if (var0 == var6 && nomeAlunos[var2] != null) {
                    var1 = true;
                    String var10001 = nomeAlunos[var2];
                    System.out.println("->" + var10001);
                }

                ++var2;
            }

            if (!var1) {
                interC.showMsg("\n!!! Nenhum aluno tem essa nota !!!\n");
            } else {
                interC.showMsg("");
            }
        } else {
            interC.showMsg("Nao ha dados");
        }

    }
    private String[] searchByName(String var1) {
        return null;
    }
}
