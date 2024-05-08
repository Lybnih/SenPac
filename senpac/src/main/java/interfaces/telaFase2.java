package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import static sun.jvm.hotspot.HelloWorld.e;


public class telaFase2 extends javax.swing.JFrame implements KeyListener{
    //Necessario para as barreiras
      private List<JPanel> barreirasJPanels = new ArrayList<>(); 
      private List<Rectangle> barreiras = new ArrayList<>();
    
    //Necessario para a direção
      private int ultimaDirecao = -1; // armazena a última direção
      private int direcao; //0: direita, 1: cima, 2: baixo
      private int frameAtual; // Controla o frame atual da animação
      private javax.swing.Timer timer;
      private Timer movimentoContinuoTimer;
    
    //Necessarios para a pontuação 
      private List<JLabel> pontos = new ArrayList<>();
      private int totalDePontos = 132; // Atualize com o número total de pontos no seu jogo
      private int pontosColetados = 0; // Inicializa o contador de pontos coletados
      private int pontuacao = 0;
      private List<JLabel> coquinha = new ArrayList<>();
      public static int pontuacaoTotal = 0;

      //Fantasma
      private List<JLabel> fantasmas = new ArrayList<>(); 
      
      //vidas
      private List<JLabel> vidas = new ArrayList<>();
      private int vidasRestantes = 3;
      
      //Fase
      private boolean proximaFaseIniciada = false;

    // Construtor da classe
    public telaFase2() { 
    initComponents();
     
        setSize(1129, 662);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);

        pacman.setBounds(670, 430, 70, 70);//Nasce nesse local
        pacman.setIcon(new javax.swing.ImageIcon("imagens/esquerda.png"));
       
        placar.setText(" " + telaFase1.pontuacaoTotal);

        // Adiciona as barreiras JPanel à lista
        barreirasJPanels.add(b1);
        barreirasJPanels.add(b2);
        barreirasJPanels.add(b3);
        barreirasJPanels.add(b4);
        barreirasJPanels.add(b5);
        barreirasJPanels.add(b7);
        barreirasJPanels.add(b8);
        barreirasJPanels.add(b9);
        barreirasJPanels.add(b10);
        barreirasJPanels.add(b11);
        barreirasJPanels.add(b12);
        barreirasJPanels.add(b13);
        barreirasJPanels.add(b14);
        barreirasJPanels.add(b15);
        barreirasJPanels.add(b17);
        barreirasJPanels.add(b18);
        barreirasJPanels.add(b19);
        barreirasJPanels.add(b20);
        barreirasJPanels.add(b21);
        barreirasJPanels.add(b22);
        barreirasJPanels.add(b23);
        barreirasJPanels.add(b24);
        barreirasJPanels.add(b25);
        barreirasJPanels.add(b26);
        barreirasJPanels.add(b27);
        barreirasJPanels.add(b28);
        barreirasJPanels.add(b30);
        barreirasJPanels.add(b32);
        barreirasJPanels.add(b33);
        barreirasJPanels.add(b34);
        barreirasJPanels.add(b35);
        barreirasJPanels.add(b36);
        barreirasJPanels.add(b37);
        barreirasJPanels.add(b38);

        
        barreirasJPanels.add(bS);
        barreirasJPanels.add(bE);
        barreirasJPanels.add(bN);
        barreirasJPanels.add(bAI);
        
        
        //Escondendo as barreiras
        b1.setBackground(new java.awt.Color(0,0,0,0));
        b2.setBackground(new java.awt.Color(0,0,0,0));
        b3.setBackground(new java.awt.Color(0,0,0,0));
        b4.setBackground(new java.awt.Color(0,0,0,0));
        b5.setBackground(new java.awt.Color(0,0,0,0));
        b7.setBackground(new java.awt.Color(0,0,0,0));
        b8.setBackground(new java.awt.Color(0,0,0,0));
        b9.setBackground(new java.awt.Color(0,0,0,0));
        b10.setBackground(new java.awt.Color(0,0,0,0));
        b11.setBackground(new java.awt.Color(0,0,0,0));
        b12.setBackground(new java.awt.Color(0,0,0,0));
        b13.setBackground(new java.awt.Color(0,0,0,0));
        b14.setBackground(new java.awt.Color(0,0,0,0));
        b15.setBackground(new java.awt.Color(0,0,0,0));
        b17.setBackground(new java.awt.Color(0,0,0,0));
        b18.setBackground(new java.awt.Color(0,0,0,0));
        b19.setBackground(new java.awt.Color(0,0,0,0));
        b20.setBackground(new java.awt.Color(0,0,0,0));
        b21.setBackground(new java.awt.Color(0,0,0,0));
        b22.setBackground(new java.awt.Color(0,0,0,0));
        b23.setBackground(new java.awt.Color(0,0,0,0));
        b24.setBackground(new java.awt.Color(0,0,0,0));
        b25.setBackground(new java.awt.Color(0,0,0,0));
        b26.setBackground(new java.awt.Color(0,0,0,0));
        b27.setBackground(new java.awt.Color(0,0,0,0));
        b28.setBackground(new java.awt.Color(0,0,0,0));
        b30.setBackground(new java.awt.Color(0,0,0,0));
        b32.setBackground(new java.awt.Color(0,0,0,0));
        b33.setBackground(new java.awt.Color(0,0,0,0));
        b34.setBackground(new java.awt.Color(0,0,0,0));
        b35.setBackground(new java.awt.Color(0,0,0,0));
        b36.setBackground(new java.awt.Color(0,0,0,0));
        b37.setBackground(new java.awt.Color(0,0,0,0));
        b38.setBackground(new java.awt.Color(0,0,0,0));
        

        //Escondendo as barreiras do SENAI
        bS.setBackground(new java.awt.Color(0,0,0,0));
        bE.setBackground(new java.awt.Color(0,0,0,0));
        bN.setBackground(new java.awt.Color(0,0,0,0));
        bAI.setBackground(new java.awt.Color(0,0,0,0));
        
        //Adicionando pontos
        pontos.add(ponto);
        pontos.add(ponto1);
        pontos.add(ponto2);
        pontos.add(ponto3);
        pontos.add(ponto4);
        pontos.add(ponto5);
        pontos.add(ponto6);
        pontos.add(ponto7);
        pontos.add(ponto8);
        pontos.add(ponto9);
        pontos.add(ponto10);
        pontos.add(ponto11);
        pontos.add(ponto12);
        pontos.add(ponto13);
        pontos.add(ponto14);
        pontos.add(ponto15);
        pontos.add(ponto16);
        pontos.add(ponto17);
        pontos.add(ponto18);
        pontos.add(ponto19);
        pontos.add(ponto20);
        pontos.add(ponto21);
        pontos.add(ponto22);
        pontos.add(ponto23);
        pontos.add(ponto24);
        pontos.add(ponto25);
        pontos.add(ponto26);
        pontos.add(ponto27);
        pontos.add(ponto28);
        pontos.add(ponto29);
        pontos.add(ponto30);
        pontos.add(ponto31);
        pontos.add(ponto32);
        pontos.add(ponto33);
        pontos.add(ponto34);
        pontos.add(ponto35);
        pontos.add(ponto36);
        pontos.add(ponto37);
        pontos.add(ponto38);
        pontos.add(ponto39);
        pontos.add(ponto40);
        pontos.add(ponto41);
        pontos.add(ponto42);
        pontos.add(ponto43);
        pontos.add(ponto44);
        pontos.add(ponto45);
        pontos.add(ponto46);
        pontos.add(ponto47);
        pontos.add(ponto48);
        pontos.add(ponto49);
        pontos.add(ponto50);
        pontos.add(ponto51);
        pontos.add(ponto52);
        pontos.add(ponto53);
        pontos.add(ponto54);
        pontos.add(ponto55);
        pontos.add(ponto56);
        pontos.add(ponto57);
        pontos.add(ponto58);
        pontos.add(ponto59);
        pontos.add(ponto60);
        pontos.add(ponto61);
        pontos.add(ponto62);
        pontos.add(ponto63);
        pontos.add(ponto64);
        pontos.add(ponto65);
        pontos.add(ponto66);
        pontos.add(ponto67);
        pontos.add(ponto68);
        pontos.add(ponto69);
        pontos.add(ponto70);
        pontos.add(ponto71);
        pontos.add(ponto72);
        pontos.add(ponto73);
        pontos.add(ponto74);
        pontos.add(ponto75);
        pontos.add(ponto76);
        pontos.add(ponto77);
        pontos.add(ponto78);
        pontos.add(ponto79);
        pontos.add(ponto80);
        pontos.add(ponto81);
        pontos.add(ponto82);
        pontos.add(ponto83);
        pontos.add(ponto84);
        pontos.add(ponto85);
        pontos.add(ponto86);
        pontos.add(ponto87);
        pontos.add(ponto88);
        pontos.add(ponto89);
        pontos.add(ponto90);
        pontos.add(ponto91);
        pontos.add(ponto92);
        pontos.add(ponto93);
        pontos.add(ponto94);
        pontos.add(ponto95);
        pontos.add(ponto96);
        pontos.add(ponto97);
        pontos.add(ponto98);
        pontos.add(ponto99);
        pontos.add(ponto100);
        pontos.add(ponto101);
        pontos.add(ponto102);
        pontos.add(ponto103);
        pontos.add(ponto104);
        pontos.add(ponto105);
        pontos.add(ponto106);
        pontos.add(ponto107);
        pontos.add(ponto108);
        pontos.add(ponto109);
        pontos.add(ponto110);
        pontos.add(ponto111);
        pontos.add(ponto112);
        pontos.add(ponto113);
        pontos.add(ponto114);
        pontos.add(ponto115);
        pontos.add(ponto116);
        pontos.add(ponto117);
        pontos.add(ponto118);
        pontos.add(ponto119);
        pontos.add(ponto120);
        pontos.add(ponto121);
        pontos.add(ponto122);
        pontos.add(ponto123);
        pontos.add(ponto124);
        pontos.add(ponto125);
        pontos.add(ponto126);
        pontos.add(ponto127);
        pontos.add(ponto128);
        pontos.add(ponto129);
        pontos.add(ponto130);
        pontos.add(ponto130); 
        pontos.add(ponto131);
        pontos.add(ponto132);
        pontos.add(ponto133);
        pontos.add(ponto134);
        pontos.add(ponto135); 
        pontos.add(ponto136);
        pontos.add(ponto137);
        pontos.add(ponto138);
        pontos.add(ponto139);
        pontos.add(ponto140);
        pontos.add(ponto141);
        pontos.add(ponto142);
        pontos.add(ponto143);
        pontos.add(ponto144);
        pontos.add(ponto145);
        pontos.add(ponto146);
        pontos.add(ponto147);
        pontos.add(ponto148);
        pontos.add(ponto149);
        pontos.add(ponto150);
        pontos.add(ponto151);
        pontos.add(ponto151);
        pontos.add(ponto152);
        pontos.add(ponto153);
        pontos.add(ponto154);
        pontos.add(ponto155);
        pontos.add(ponto156);
        
        coquinha.add(coca);
        
        //Adiciona fantasmas 
        fantasmas.add(fantasma1);
        fantasmas.add(fantasma2);
        
        
        
        //Temporizador fantasma
        Timer movimentoFantasmasTimer = new Timer(200, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        moverFantasmas();
    }
});

movimentoFantasmasTimer.start(); // Inicie o temporizador    
        
    // Inicializa o temporizador para alternar os frames a cada 200 milissegundos (5 quadros por segundo)
        timer = new Timer(1000000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alternarFrame();
            }
        });
        timer.start();
        
        movimentoContinuoTimer = new Timer(100, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        continuarMovimento(); // Chama o método para continuar o movimento
    }
  });
  movimentoContinuoTimer.start(); // Inicia o temporizador


    }//Acaba construtor
    
    // metodo movimentos
    private boolean verificarMovimento(int novaPosX, int novaPosY) {
    Rectangle novoPacman = new Rectangle(novaPosX, novaPosY, 50, 50);

    for (Rectangle barreira : barreiras) {
        if (novoPacman.intersects(barreira)) {
            return false; // O movimento não é válido
        }
    }

    for (JPanel barreiraPanel : barreirasJPanels) {
        if (novoPacman.getBounds().intersects(barreiraPanel.getBounds())) {
            return false; // O movimento não é válido
        }
    }

    return true; // O movimento é válido
    }
    
    // Método para alternar os frames
    private void alternarFrame() {
    frameAtual++;
    if (frameAtual > 3) {
        frameAtual = 0; // Volta para o primeiro frame
    }

    // Atualiza a imagem do pacman de acordo com a direção atual e o frame atual
    String caminhoImagem = String.format("imagens/%s.png", obterDirecaoComoString());
    pacman.setIcon(new javax.swing.ImageIcon(caminhoImagem));
}

    // Converte a direção para uma string para formar o caminho da imagem
    private String obterDirecaoComoString() {
        switch (direcao) {
            case 0: return "direita";
            case 1: return "cima";
            case 2: return "baixo";
            default: return "direita";
        }
    }
    
    // Adicione este método para que o Pac-Man continue se movendo na última direção
private void continuarMovimento() {
    int novaPosX = pacman.getX();
    int novaPosY = pacman.getY();

    if (ultimaDirecao == 1) {
        novaPosY -= 10;
    } else if (ultimaDirecao == 2) {
        novaPosY += 10;
    } else if (ultimaDirecao == 0) {
        novaPosX -= 10;
    } else if (ultimaDirecao == 3) {
        novaPosX += 10;
    }
    
    if (novaPosX < 0) {
        novaPosX = getWidth(); // Reposiciona para o lado direito
    } else if (novaPosX > getWidth()) {
        novaPosX = 0; // Reposiciona para o lado esquerdo
    }
    verificarColisaoComPontos();// Verifica a colisão com os pontos


    if (verificarMovimento(novaPosX, novaPosY)) {
        pacman.setLocation(novaPosX, novaPosY);
    }
     verificarColisaoComPontos(); // Verifica a colisão com os pontos
    verificarColisaoComFantasmas();
    
    
}


private void verificarColisaoComPontos() {
    Rectangle pacmanBounds = pacman.getBounds();

    for (JLabel ponto : pontos) {
        if (pacmanBounds.intersects(ponto.getBounds()) && ponto.isVisible()) {
            ponto.setVisible(false); // Esconde o ponto
            
            pontosColetados++; // Incrementa o contador de pontos
            pontuacao += 25;// Atualiza a pontuação
            placar.setText(" " + pontuacao); // Atualiza o texto do JLabel "placar"
        }
    }
    for (JLabel pontoEspecial : coquinha) {
        if (pacmanBounds.intersects(pontoEspecial.getBounds()) && pontoEspecial.isVisible()) {
            pontoEspecial.setVisible(false); // Esconde o ponto especial
            pontuacao += 500; // Adiciona 500 pontos
        }
    }

    // Verifique se todos os pontos foram coletados (condição de vitória)
    if (pontosColetados == totalDePontos) {
        iniciarProximaFase();
    }
}
private int seguirPacman(JLabel fantasma, JLabel pacman) {
    int deltaX = pacman.getX() - fantasma.getX();
    int deltaY = pacman.getY() - fantasma.getY();

    if (Math.abs(deltaX) > Math.abs(deltaY)) {
        return (deltaX > 0) ? 3 : 0; // Move horizontalmente em direção ao Pac-Man
    } else {
        return (deltaY > 0) ? 2 : 1; // Move verticalmente em direção ao Pac-Man
    }
}

private void moverFantasmas() {
    Random random = new Random();

    for (JLabel fantasma : fantasmas) {
        int direcao = seguirPacman(fantasma, pacman);
        int novaPosX = fantasma.getX();
        int novaPosY = fantasma.getY();

        for (int i = 0; i < 4; i++) {
            if (direcao == 0) {
                novaPosX -= 10;
            } else if (direcao == 1) {
                novaPosY -= 10;
            } else if (direcao == 2) {
                novaPosY += 10;
            } else if (direcao == 3) {
                novaPosX += 10;
            }

            if (verificarMovimento(novaPosX, novaPosY)) {
                fantasma.setLocation(novaPosX, novaPosY);
                break;
            } else {
                // Se o movimento não for válido, tente outra direção
                direcao = (direcao + 1) % 4;
                novaPosX = fantasma.getX();
                novaPosY = fantasma.getY();
            }
        }
    }
    
}
private void reiniciarPosicaoPacman() {
    pacman.setBounds(670, 430, 70, 70); // Posição inicial
    pacman.setIcon(new javax.swing.ImageIcon("imagens/esquerda.png"));
}

private void verificarColisaoComFantasmas() {
    Rectangle pacmanBounds = pacman.getBounds();

    for (JLabel fantasma : fantasmas) {
        if (pacmanBounds.intersects(fantasma.getBounds()) && fantasma.isVisible()) {
            reiniciarPosicaoPacman(); // Reposiciona o Pac-Man
            
            // Esconde uma vida
            if (vida1.isVisible()) {
                vida1.setVisible(false);
            } else if (vida2.isVisible()) {
                vida2.setVisible(false);
            } else if (vida3.isVisible()) {
                vida3.setVisible(false);
            }
            
            // Verifica se todas as vidas foram perdidas
            if (!vida3.isVisible() && !vida2.isVisible() && !vida1.isVisible()) {
                // Todas as vidas foram perdidas, exibir mensagem de Game Over
                int pontuacaoFinal = pontuacao; // Salva a pontuação final
                String mensagem = "Game Over! Pontuação final: " + pontuacaoFinal;
                JOptionPane.showMessageDialog(this, mensagem, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            // Reinicia o jogo
              reiniciarJogo();
            }
            
            break; // Sai do loop, já que não há necessidade de continuar verificando
        }
    }
}

private void reiniciarJogo() {
    System.out.println("Reiniciando o jogo...");

    // Zera a pontuação
    pontuacao = 0;
    pontosColetados = 0;

    // Esconde a tela atual
    this.setVisible(false);

    // Mostra a tela de início
    telaInicio telaInicio = new telaInicio(); // Substitua TelaInicio pelo nome da sua classe de tela de início
    telaInicio.setVisible(true);

}


private void iniciarProximaFase() {
    if (proximaFaseIniciada) {
        return; // Se a próxima fase já foi iniciada, não faz nada
    }

    proximaFaseIniciada = true; // Marca a próxima fase como iniciada
    
    int pontuacaoFinal = pontuacao;
    String mensagem = "Você coletou todos os pontos!\nSua pontuação final é: " + pontuacaoFinal;
    JOptionPane.showMessageDialog(null, mensagem);

    telaFase3.pontuacaoTotal += pontuacaoFinal;
    
    telaFase3 fase3 = new telaFase3();
    fase3.setVisible(true);
    dispose();
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        b30 = new javax.swing.JPanel();
        ponto19 = new javax.swing.JLabel();
        ponto20 = new javax.swing.JLabel();
        ponto21 = new javax.swing.JLabel();
        ponto22 = new javax.swing.JLabel();
        ponto23 = new javax.swing.JLabel();
        ponto24 = new javax.swing.JLabel();
        ponto25 = new javax.swing.JLabel();
        ponto26 = new javax.swing.JLabel();
        b35 = new javax.swing.JPanel();
        b36 = new javax.swing.JPanel();
        ponto77 = new javax.swing.JLabel();
        ponto78 = new javax.swing.JLabel();
        ponto79 = new javax.swing.JLabel();
        ponto80 = new javax.swing.JLabel();
        ponto81 = new javax.swing.JLabel();
        ponto82 = new javax.swing.JLabel();
        ponto83 = new javax.swing.JLabel();
        ponto84 = new javax.swing.JLabel();
        ponto85 = new javax.swing.JLabel();
        ponto86 = new javax.swing.JLabel();
        ponto87 = new javax.swing.JLabel();
        ponto88 = new javax.swing.JLabel();
        ponto89 = new javax.swing.JLabel();
        ponto90 = new javax.swing.JLabel();
        ponto91 = new javax.swing.JLabel();
        ponto92 = new javax.swing.JLabel();
        b1 = new javax.swing.JPanel();
        b37 = new javax.swing.JPanel();
        ponto140 = new javax.swing.JLabel();
        pacman = new javax.swing.JLabel();
        fantasma1 = new javax.swing.JLabel();
        fantasma2 = new javax.swing.JLabel();
        b12 = new javax.swing.JPanel();
        bAI = new javax.swing.JPanel();
        b2 = new javax.swing.JPanel();
        bS = new javax.swing.JPanel();
        bN = new javax.swing.JPanel();
        bE = new javax.swing.JPanel();
        b3 = new javax.swing.JPanel();
        b4 = new javax.swing.JPanel();
        b5 = new javax.swing.JPanel();
        b8 = new javax.swing.JPanel();
        b9 = new javax.swing.JPanel();
        b10 = new javax.swing.JPanel();
        b11 = new javax.swing.JPanel();
        b7 = new javax.swing.JPanel();
        b13 = new javax.swing.JPanel();
        b14 = new javax.swing.JPanel();
        b15 = new javax.swing.JPanel();
        b17 = new javax.swing.JPanel();
        b18 = new javax.swing.JPanel();
        b19 = new javax.swing.JPanel();
        b20 = new javax.swing.JPanel();
        b22 = new javax.swing.JPanel();
        b21 = new javax.swing.JPanel();
        b23 = new javax.swing.JPanel();
        b24 = new javax.swing.JPanel();
        b25 = new javax.swing.JPanel();
        b26 = new javax.swing.JPanel();
        b27 = new javax.swing.JPanel();
        b28 = new javax.swing.JPanel();
        ponto = new javax.swing.JLabel();
        ponto1 = new javax.swing.JLabel();
        ponto2 = new javax.swing.JLabel();
        ponto3 = new javax.swing.JLabel();
        ponto4 = new javax.swing.JLabel();
        ponto5 = new javax.swing.JLabel();
        ponto7 = new javax.swing.JLabel();
        ponto8 = new javax.swing.JLabel();
        ponto9 = new javax.swing.JLabel();
        ponto10 = new javax.swing.JLabel();
        ponto11 = new javax.swing.JLabel();
        ponto12 = new javax.swing.JLabel();
        ponto13 = new javax.swing.JLabel();
        ponto14 = new javax.swing.JLabel();
        ponto6 = new javax.swing.JLabel();
        ponto15 = new javax.swing.JLabel();
        ponto16 = new javax.swing.JLabel();
        ponto17 = new javax.swing.JLabel();
        b32 = new javax.swing.JPanel();
        ponto18 = new javax.swing.JLabel();
        b33 = new javax.swing.JPanel();
        b34 = new javax.swing.JPanel();
        ponto27 = new javax.swing.JLabel();
        ponto28 = new javax.swing.JLabel();
        ponto29 = new javax.swing.JLabel();
        ponto30 = new javax.swing.JLabel();
        ponto31 = new javax.swing.JLabel();
        ponto32 = new javax.swing.JLabel();
        ponto33 = new javax.swing.JLabel();
        ponto34 = new javax.swing.JLabel();
        ponto35 = new javax.swing.JLabel();
        ponto36 = new javax.swing.JLabel();
        ponto37 = new javax.swing.JLabel();
        ponto39 = new javax.swing.JLabel();
        ponto38 = new javax.swing.JLabel();
        ponto40 = new javax.swing.JLabel();
        ponto41 = new javax.swing.JLabel();
        ponto42 = new javax.swing.JLabel();
        ponto43 = new javax.swing.JLabel();
        ponto44 = new javax.swing.JLabel();
        ponto45 = new javax.swing.JLabel();
        ponto46 = new javax.swing.JLabel();
        ponto47 = new javax.swing.JLabel();
        ponto48 = new javax.swing.JLabel();
        ponto49 = new javax.swing.JLabel();
        ponto50 = new javax.swing.JLabel();
        ponto51 = new javax.swing.JLabel();
        ponto52 = new javax.swing.JLabel();
        ponto53 = new javax.swing.JLabel();
        ponto54 = new javax.swing.JLabel();
        ponto55 = new javax.swing.JLabel();
        ponto56 = new javax.swing.JLabel();
        ponto57 = new javax.swing.JLabel();
        ponto58 = new javax.swing.JLabel();
        ponto59 = new javax.swing.JLabel();
        ponto60 = new javax.swing.JLabel();
        ponto61 = new javax.swing.JLabel();
        ponto62 = new javax.swing.JLabel();
        ponto63 = new javax.swing.JLabel();
        ponto64 = new javax.swing.JLabel();
        ponto65 = new javax.swing.JLabel();
        ponto66 = new javax.swing.JLabel();
        ponto67 = new javax.swing.JLabel();
        ponto68 = new javax.swing.JLabel();
        ponto69 = new javax.swing.JLabel();
        ponto70 = new javax.swing.JLabel();
        ponto71 = new javax.swing.JLabel();
        ponto72 = new javax.swing.JLabel();
        ponto73 = new javax.swing.JLabel();
        ponto74 = new javax.swing.JLabel();
        ponto75 = new javax.swing.JLabel();
        ponto76 = new javax.swing.JLabel();
        ponto93 = new javax.swing.JLabel();
        ponto94 = new javax.swing.JLabel();
        ponto95 = new javax.swing.JLabel();
        ponto96 = new javax.swing.JLabel();
        ponto97 = new javax.swing.JLabel();
        ponto98 = new javax.swing.JLabel();
        ponto99 = new javax.swing.JLabel();
        ponto100 = new javax.swing.JLabel();
        ponto101 = new javax.swing.JLabel();
        ponto102 = new javax.swing.JLabel();
        ponto103 = new javax.swing.JLabel();
        ponto104 = new javax.swing.JLabel();
        ponto105 = new javax.swing.JLabel();
        ponto106 = new javax.swing.JLabel();
        ponto107 = new javax.swing.JLabel();
        ponto108 = new javax.swing.JLabel();
        ponto109 = new javax.swing.JLabel();
        ponto110 = new javax.swing.JLabel();
        ponto111 = new javax.swing.JLabel();
        ponto112 = new javax.swing.JLabel();
        ponto113 = new javax.swing.JLabel();
        ponto114 = new javax.swing.JLabel();
        ponto115 = new javax.swing.JLabel();
        b38 = new javax.swing.JPanel();
        vida3 = new javax.swing.JLabel();
        vida1 = new javax.swing.JLabel();
        vida2 = new javax.swing.JLabel();
        placar = new javax.swing.JLabel();
        ponto116 = new javax.swing.JLabel();
        ponto117 = new javax.swing.JLabel();
        ponto118 = new javax.swing.JLabel();
        ponto119 = new javax.swing.JLabel();
        ponto120 = new javax.swing.JLabel();
        ponto121 = new javax.swing.JLabel();
        ponto122 = new javax.swing.JLabel();
        ponto123 = new javax.swing.JLabel();
        ponto124 = new javax.swing.JLabel();
        ponto125 = new javax.swing.JLabel();
        ponto126 = new javax.swing.JLabel();
        ponto127 = new javax.swing.JLabel();
        ponto128 = new javax.swing.JLabel();
        ponto129 = new javax.swing.JLabel();
        ponto130 = new javax.swing.JLabel();
        ponto131 = new javax.swing.JLabel();
        ponto132 = new javax.swing.JLabel();
        ponto133 = new javax.swing.JLabel();
        ponto134 = new javax.swing.JLabel();
        ponto135 = new javax.swing.JLabel();
        ponto136 = new javax.swing.JLabel();
        ponto137 = new javax.swing.JLabel();
        ponto138 = new javax.swing.JLabel();
        ponto139 = new javax.swing.JLabel();
        ponto141 = new javax.swing.JLabel();
        ponto142 = new javax.swing.JLabel();
        ponto143 = new javax.swing.JLabel();
        ponto144 = new javax.swing.JLabel();
        ponto145 = new javax.swing.JLabel();
        ponto146 = new javax.swing.JLabel();
        ponto147 = new javax.swing.JLabel();
        ponto148 = new javax.swing.JLabel();
        ponto149 = new javax.swing.JLabel();
        ponto150 = new javax.swing.JLabel();
        ponto151 = new javax.swing.JLabel();
        ponto152 = new javax.swing.JLabel();
        ponto153 = new javax.swing.JLabel();
        ponto154 = new javax.swing.JLabel();
        ponto155 = new javax.swing.JLabel();
        ponto156 = new javax.swing.JLabel();
        coca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        b30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b30MouseClicked(evt);
            }
        });

        ponto19.setText("jLabel4");

        ponto20.setText("jLabel4");

        ponto21.setText("jLabel4");

        ponto22.setText("jLabel4");

        ponto23.setText("jLabel4");

        ponto24.setText("jLabel4");

        ponto25.setText("jLabel4");

        ponto26.setText("jLabel4");

        b35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b35MouseClicked(evt);
            }
        });

        b36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b36MouseClicked(evt);
            }
        });

        ponto77.setText("jLabel4");

        ponto78.setText("jLabel4");

        ponto79.setText("jLabel4");

        ponto80.setText("jLabel4");

        ponto81.setText("jLabel4");

        ponto82.setText("jLabel4");

        ponto83.setText("jLabel4");

        ponto84.setText("jLabel4");

        ponto85.setText("jLabel4");

        ponto86.setText("jLabel4");

        ponto87.setText("jLabel4");

        ponto88.setText("jLabel4");

        ponto89.setText("jLabel4");

        ponto90.setText("jLabel4");

        ponto91.setText("jLabel4");

        ponto92.setText("jLabel4");

        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });

        b37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b37MouseClicked(evt);
            }
        });

        ponto140.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pacman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/esquerda.png"))); // NOI18N
        getContentPane().add(pacman);
        pacman.setBounds(690, 450, 20, 30);

        fantasma1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fantasma1.png"))); // NOI18N
        fantasma1.setText("jLabel3");
        getContentPane().add(fantasma1);
        fantasma1.setBounds(280, 230, 30, 30);

        fantasma2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fantasma2.png"))); // NOI18N
        fantasma2.setText("jLabel3");
        getContentPane().add(fantasma2);
        fantasma2.setBounds(960, 240, 30, 30);

        b12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b12MouseClicked(evt);
            }
        });
        getContentPane().add(b12);
        b12.setBounds(630, 330, 120, 10);

        bAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bAIMouseClicked(evt);
            }
        });
        getContentPane().add(bAI);
        bAI.setBounds(820, 280, 150, 90);

        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b2MouseClicked(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(0, 490, 1130, 170);

        bS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSMouseClicked(evt);
            }
        });
        getContentPane().add(bS);
        bS.setBounds(140, 220, 90, 150);

        bN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNMouseClicked(evt);
            }
        });
        getContentPane().add(bN);
        bN.setBounds(480, 280, 90, 90);

        bE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bEMouseClicked(evt);
            }
        });
        getContentPane().add(bE);
        bE.setBounds(310, 270, 100, 100);

        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b3MouseClicked(evt);
            }
        });
        getContentPane().add(b3);
        b3.setBounds(690, 400, 10, 30);

        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b4MouseClicked(evt);
            }
        });
        getContentPane().add(b4);
        b4.setBounds(640, 390, 110, 10);

        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b5MouseClicked(evt);
            }
        });
        getContentPane().add(b5);
        b5.setBounds(750, 450, 10, 40);

        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b8MouseClicked(evt);
            }
        });
        getContentPane().add(b8);
        b8.setBounds(630, 270, 10, 70);

        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b9MouseClicked(evt);
            }
        });
        getContentPane().add(b9);
        b9.setBounds(740, 270, 10, 70);

        b10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b10MouseClicked(evt);
            }
        });
        getContentPane().add(b10);
        b10.setBounds(640, 270, 30, 10);

        b11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b11MouseClicked(evt);
            }
        });
        getContentPane().add(b11);
        b11.setBounds(730, 270, 20, 10);

        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b7MouseClicked(evt);
            }
        });
        getContentPane().add(b7);
        b7.setBounds(1040, 270, 90, 20);

        b13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b13MouseClicked(evt);
            }
        });
        getContentPane().add(b13);
        b13.setBounds(320, 210, 250, 10);

        b14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b14MouseClicked(evt);
            }
        });
        getContentPane().add(b14);
        b14.setBounds(820, 210, 240, 10);

        b15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b15MouseClicked(evt);
            }
        });
        getContentPane().add(b15);
        b15.setBounds(650, 210, 100, 10);

        b17.setAlignmentY(0.2F);
        b17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b17MouseClicked(evt);
            }
        });
        getContentPane().add(b17);
        b17.setBounds(1120, 350, 10, 140);

        b18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b18MouseClicked(evt);
            }
        });
        getContentPane().add(b18);
        b18.setBounds(820, 430, 120, 10);

        b19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b19MouseClicked(evt);
            }
        });
        getContentPane().add(b19);
        b19.setBounds(0, 270, 70, 20);

        b20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b20MouseClicked(evt);
            }
        });
        getContentPane().add(b20);
        b20.setBounds(1020, 430, 40, 10);

        b22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b22MouseClicked(evt);
            }
        });
        getContentPane().add(b22);
        b22.setBounds(0, 370, 10, 130);

        b21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b21MouseClicked(evt);
            }
        });
        getContentPane().add(b21);
        b21.setBounds(160, 430, 140, 10);

        b23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b23MouseClicked(evt);
            }
        });
        getContentPane().add(b23);
        b23.setBounds(1040, 350, 90, 20);

        b24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b24MouseClicked(evt);
            }
        });
        getContentPane().add(b24);
        b24.setBounds(0, 350, 70, 20);

        b25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b25MouseClicked(evt);
            }
        });
        getContentPane().add(b25);
        b25.setBounds(60, 210, 20, 10);

        b26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b26MouseClicked(evt);
            }
        });
        getContentPane().add(b26);
        b26.setBounds(60, 430, 30, 10);

        b27.setAlignmentY(0.2F);
        b27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b27MouseClicked(evt);
            }
        });
        getContentPane().add(b27);
        b27.setBounds(0, 140, 10, 140);

        b28.setAlignmentY(0.2F);
        b28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b28MouseClicked(evt);
            }
        });
        getContentPane().add(b28);
        b28.setBounds(1120, 150, 10, 140);

        ponto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto.setText("jLabel4");
        getContentPane().add(ponto);
        ponto.setBounds(1040, 250, 40, 16);

        ponto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto1.setText("jLabel4");
        getContentPane().add(ponto1);
        ponto1.setBounds(580, 340, 40, 16);

        ponto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto2.setText("jLabel4");
        getContentPane().add(ponto2);
        ponto2.setBounds(410, 240, 40, 16);

        ponto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto3.setText("jLabel4");
        getContentPane().add(ponto3);
        ponto3.setBounds(880, 250, 40, 16);

        ponto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto4.setText("jLabel4");
        getContentPane().add(ponto4);
        ponto4.setBounds(500, 240, 40, 16);

        ponto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto5.setText("jLabel4");
        getContentPane().add(ponto5);
        ponto5.setBounds(960, 470, 40, 16);

        ponto7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto7.setText("jLabel4");
        getContentPane().add(ponto7);
        ponto7.setBounds(540, 240, 40, 16);

        ponto8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto8.setText("jLabel4");
        getContentPane().add(ponto8);
        ponto8.setBounds(320, 400, 40, 16);

        ponto9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto9.setText("jLabel4");
        getContentPane().add(ponto9);
        ponto9.setBounds(580, 370, 40, 16);

        ponto10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto10.setText("jLabel4");
        getContentPane().add(ponto10);
        ponto10.setBounds(430, 340, 40, 16);

        ponto11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto11.setText("jLabel4");
        getContentPane().add(ponto11);
        ponto11.setBounds(320, 430, 40, 16);

        ponto12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto12.setText("jLabel4");
        getContentPane().add(ponto12);
        ponto12.setBounds(430, 370, 40, 16);

        ponto13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto13.setText("jLabel4");
        getContentPane().add(ponto13);
        ponto13.setBounds(430, 310, 40, 16);

        ponto14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto14.setText("jLabel4");
        getContentPane().add(ponto14);
        ponto14.setBounds(430, 280, 40, 16);

        ponto6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto6.setText("jLabel4");
        getContentPane().add(ponto6);
        ponto6.setBounds(580, 250, 40, 16);

        ponto15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto15.setText("jLabel4");
        getContentPane().add(ponto15);
        ponto15.setBounds(0, 430, 40, 16);

        ponto16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto16.setText("jLabel4");
        getContentPane().add(ponto16);
        ponto16.setBounds(450, 240, 40, 16);

        ponto17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto17.setText("jLabel4");
        getContentPane().add(ponto17);
        ponto17.setBounds(840, 250, 40, 16);

        b32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b32MouseClicked(evt);
            }
        });
        getContentPane().add(b32);
        b32.setBounds(360, 430, 10, 60);

        ponto18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto18.setText("jLabel4");
        getContentPane().add(ponto18);
        ponto18.setBounds(580, 310, 40, 16);

        b33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b33MouseClicked(evt);
            }
        });
        getContentPane().add(b33);
        b33.setBounds(430, 430, 150, 10);

        b34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b34MouseClicked(evt);
            }
        });
        getContentPane().add(b34);
        b34.setBounds(630, 450, 10, 40);

        ponto27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto27.setText("jLabel4");
        getContentPane().add(ponto27);
        ponto27.setBounds(370, 460, 40, 16);

        ponto28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto28.setText("jLabel4");
        getContentPane().add(ponto28);
        ponto28.setBounds(580, 430, 40, 16);

        ponto29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto29.setText("jLabel4");
        getContentPane().add(ponto29);
        ponto29.setBounds(760, 290, 40, 16);

        ponto30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto30.setText("jLabel4");
        getContentPane().add(ponto30);
        ponto30.setBounds(760, 250, 40, 16);

        ponto31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto31.setText("jLabel4");
        getContentPane().add(ponto31);
        ponto31.setBounds(410, 460, 40, 16);

        ponto32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto32.setText("jLabel4");
        getContentPane().add(ponto32);
        ponto32.setBounds(760, 320, 40, 16);

        ponto33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto33.setText("jLabel4");
        getContentPane().add(ponto33);
        ponto33.setBounds(450, 460, 40, 16);

        ponto34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto34.setText("jLabel4");
        getContentPane().add(ponto34);
        ponto34.setBounds(540, 460, 40, 16);

        ponto35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto35.setText("jLabel4");
        getContentPane().add(ponto35);
        ponto35.setBounds(370, 430, 40, 16);

        ponto36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto36.setText("jLabel4");
        getContentPane().add(ponto36);
        ponto36.setBounds(580, 400, 40, 16);

        ponto37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto37.setText("jLabel4");
        getContentPane().add(ponto37);
        ponto37.setBounds(370, 400, 40, 16);

        ponto39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto39.setText("jLabel4");
        getContentPane().add(ponto39);
        ponto39.setBounds(410, 400, 40, 16);

        ponto38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto38.setText("jLabel4");
        getContentPane().add(ponto38);
        ponto38.setBounds(800, 250, 40, 16);

        ponto40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto40.setText("jLabel4");
        getContentPane().add(ponto40);
        ponto40.setBounds(540, 400, 40, 16);

        ponto41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto41.setText("jLabel4");
        getContentPane().add(ponto41);
        ponto41.setBounds(450, 400, 40, 16);

        ponto42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto42.setText("jLabel4");
        getContentPane().add(ponto42);
        ponto42.setBounds(500, 460, 40, 16);

        ponto43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto43.setText("jLabel4");
        getContentPane().add(ponto43);
        ponto43.setBounds(500, 400, 40, 16);

        ponto44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto44.setText("jLabel4");
        getContentPane().add(ponto44);
        ponto44.setBounds(580, 460, 40, 16);

        ponto45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto45.setText("jLabel4");
        getContentPane().add(ponto45);
        ponto45.setBounds(250, 250, 40, 16);

        ponto46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto46.setText("jLabel4");
        getContentPane().add(ponto46);
        ponto46.setBounds(270, 400, 40, 16);

        ponto47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto47.setText("jLabel4");
        getContentPane().add(ponto47);
        ponto47.setBounds(1000, 250, 40, 16);

        ponto48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto48.setText("jLabel4");
        getContentPane().add(ponto48);
        ponto48.setBounds(250, 370, 40, 16);

        ponto49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto49.setText("jLabel4");
        getContentPane().add(ponto49);
        ponto49.setBounds(250, 340, 40, 16);

        ponto50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto50.setText("jLabel4");
        getContentPane().add(ponto50);
        ponto50.setBounds(250, 310, 40, 16);

        ponto51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto51.setText("jLabel4");
        getContentPane().add(ponto51);
        ponto51.setBounds(250, 280, 40, 16);

        ponto52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto52.setText("jLabel4");
        getContentPane().add(ponto52);
        ponto52.setBounds(250, 220, 40, 16);

        ponto53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto53.setText("jLabel4");
        getContentPane().add(ponto53);
        ponto53.setBounds(320, 460, 40, 16);

        ponto54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto54.setText("jLabel4");
        getContentPane().add(ponto54);
        ponto54.setBounds(120, 460, 40, 16);

        ponto55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto55.setText("jLabel4");
        getContentPane().add(ponto55);
        ponto55.setBounds(200, 460, 40, 16);

        ponto56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto56.setText("jLabel4");
        getContentPane().add(ponto56);
        ponto56.setBounds(960, 250, 40, 16);

        ponto57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto57.setText("jLabel4");
        getContentPane().add(ponto57);
        ponto57.setBounds(240, 460, 40, 16);

        ponto58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto58.setText("jLabel4");
        getContentPane().add(ponto58);
        ponto58.setBounds(920, 250, 40, 16);

        ponto59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto59.setText("jLabel4");
        getContentPane().add(ponto59);
        ponto59.setBounds(280, 460, 40, 16);

        ponto60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto60.setText("jLabel4");
        getContentPane().add(ponto60);
        ponto60.setBounds(160, 460, 40, 16);

        ponto61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto61.setText("jLabel4");
        getContentPane().add(ponto61);
        ponto61.setBounds(370, 180, 40, 16);

        ponto62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto62.setText("jLabel4");
        getContentPane().add(ponto62);
        ponto62.setBounds(100, 430, 40, 16);

        ponto63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto63.setText("jLabel4");
        getContentPane().add(ponto63);
        ponto63.setBounds(990, 350, 40, 16);

        ponto64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto64.setText("jLabel4");
        getContentPane().add(ponto64);
        ponto64.setBounds(40, 460, 40, 16);

        ponto65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto65.setText("jLabel4");
        getContentPane().add(ponto65);
        ponto65.setBounds(0, 460, 40, 16);

        ponto66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto66.setText("jLabel4");
        getContentPane().add(ponto66);
        ponto66.setBounds(80, 460, 40, 16);

        ponto67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto67.setText("jLabel4");
        getContentPane().add(ponto67);
        ponto67.setBounds(370, 240, 40, 16);

        ponto68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto68.setText("jLabel4");
        getContentPane().add(ponto68);
        ponto68.setBounds(330, 240, 40, 16);

        ponto69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto69.setText("jLabel4");
        getContentPane().add(ponto69);
        ponto69.setBounds(90, 220, 40, 16);

        ponto70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto70.setText("jLabel4");
        getContentPane().add(ponto70);
        ponto70.setBounds(1080, 250, 40, 16);

        ponto71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto71.setText("jLabel4");
        getContentPane().add(ponto71);
        ponto71.setBounds(40, 180, 40, 16);

        ponto72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto72.setText("jLabel4");
        getContentPane().add(ponto72);
        ponto72.setBounds(0, 180, 40, 16);

        ponto73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto73.setText("jLabel4");
        getContentPane().add(ponto73);
        ponto73.setBounds(0, 250, 40, 16);

        ponto74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto74.setText("jLabel4");
        getContentPane().add(ponto74);
        ponto74.setBounds(0, 220, 40, 16);

        ponto75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto75.setText("jLabel4");
        getContentPane().add(ponto75);
        ponto75.setBounds(40, 250, 40, 16);

        ponto76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto76.setText("jLabel4");
        getContentPane().add(ponto76);
        ponto76.setBounds(90, 310, 40, 16);

        ponto93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto93.setText("jLabel4");
        getContentPane().add(ponto93);
        ponto93.setBounds(320, 180, 40, 16);

        ponto94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto94.setText("jLabel4");
        getContentPane().add(ponto94);
        ponto94.setBounds(760, 180, 40, 16);

        ponto95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto95.setText("jLabel4");
        getContentPane().add(ponto95);
        ponto95.setBounds(90, 180, 40, 16);

        ponto96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto96.setText("jLabel4");
        getContentPane().add(ponto96);
        ponto96.setBounds(1080, 210, 40, 16);

        ponto97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto97.setText("jLabel4");
        getContentPane().add(ponto97);
        ponto97.setBounds(130, 180, 40, 16);

        ponto98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto98.setText("jLabel4");
        getContentPane().add(ponto98);
        ponto98.setBounds(1080, 180, 40, 16);

        ponto99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto99.setText("jLabel4");
        getContentPane().add(ponto99);
        ponto99.setBounds(180, 180, 40, 16);

        ponto100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto100.setText("jLabel4");
        getContentPane().add(ponto100);
        ponto100.setBounds(230, 180, 40, 16);

        ponto101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto101.setText("jLabel4");
        getContentPane().add(ponto101);
        ponto101.setBounds(270, 180, 40, 16);

        ponto102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto102.setText("jLabel4");
        getContentPane().add(ponto102);
        ponto102.setBounds(90, 250, 40, 16);

        ponto103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto103.setText("jLabel4");
        getContentPane().add(ponto103);
        ponto103.setBounds(90, 340, 40, 16);

        ponto104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto104.setText("jLabel4");
        getContentPane().add(ponto104);
        ponto104.setBounds(0, 400, 40, 16);

        ponto105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto105.setText("jLabel4");
        getContentPane().add(ponto105);
        ponto105.setBounds(90, 280, 40, 16);

        ponto106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto106.setText("jLabel4");
        getContentPane().add(ponto106);
        ponto106.setBounds(990, 320, 40, 16);

        ponto107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto107.setText("jLabel4");
        getContentPane().add(ponto107);
        ponto107.setBounds(230, 400, 40, 16);

        ponto108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto108.setText("jLabel4");
        getContentPane().add(ponto108);
        ponto108.setBounds(90, 370, 40, 16);

        ponto109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto109.setText("jLabel4");
        getContentPane().add(ponto109);
        ponto109.setBounds(90, 400, 40, 16);

        ponto110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto110.setText("jLabel4");
        getContentPane().add(ponto110);
        ponto110.setBounds(130, 400, 40, 16);

        ponto111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto111.setText("jLabel4");
        getContentPane().add(ponto111);
        ponto111.setBounds(40, 400, 40, 16);

        ponto112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto112.setText("jLabel4");
        getContentPane().add(ponto112);
        ponto112.setBounds(990, 290, 40, 16);

        ponto113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto113.setText("jLabel4");
        getContentPane().add(ponto113);
        ponto113.setBounds(180, 400, 40, 16);

        ponto114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto114.setText("jLabel4");
        getContentPane().add(ponto114);
        ponto114.setBounds(450, 180, 40, 16);

        ponto115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto115.setText("jLabel4");
        getContentPane().add(ponto115);
        ponto115.setBounds(1040, 180, 40, 16);

        b38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b38MouseClicked(evt);
            }
        });
        b38.setLayout(null);

        vida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vida.png"))); // NOI18N
        vida3.setText("jLabel4");
        b38.add(vida3);
        vida3.setBounds(590, 110, 40, 40);

        vida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vida.png"))); // NOI18N
        vida1.setText("jLabel4");
        b38.add(vida1);
        vida1.setBounds(510, 110, 40, 40);

        vida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vida.png"))); // NOI18N
        vida2.setText("jLabel4");
        b38.add(vida2);
        vida2.setBounds(550, 110, 40, 40);

        placar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        placar.setForeground(new java.awt.Color(255, 255, 255));
        placar.setText("0");
        b38.add(placar);
        placar.setBounds(150, 110, 170, 40);

        getContentPane().add(b38);
        b38.setBounds(0, 0, 1130, 160);

        ponto116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto116.setText("jLabel4");
        getContentPane().add(ponto116);
        ponto116.setBounds(410, 180, 40, 16);

        ponto117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto117.setText("jLabel4");
        getContentPane().add(ponto117);
        ponto117.setBounds(800, 180, 40, 16);

        ponto118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto118.setText("jLabel4");
        getContentPane().add(ponto118);
        ponto118.setBounds(290, 240, 40, 16);

        ponto119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto119.setText("jLabel4");
        getContentPane().add(ponto119);
        ponto119.setBounds(500, 180, 40, 16);

        ponto120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto120.setText("jLabel4");
        getContentPane().add(ponto120);
        ponto120.setBounds(540, 180, 40, 16);

        ponto121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto121.setText("jLabel4");
        getContentPane().add(ponto121);
        ponto121.setBounds(670, 180, 40, 16);

        ponto122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto122.setText("jLabel4");
        getContentPane().add(ponto122);
        ponto122.setBounds(580, 180, 40, 16);

        ponto123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto123.setText("jLabel4");
        getContentPane().add(ponto123);
        ponto123.setBounds(580, 220, 40, 16);

        ponto124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto124.setText("jLabel4");
        getContentPane().add(ponto124);
        ponto124.setBounds(620, 180, 40, 16);

        ponto125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto125.setText("jLabel4");
        getContentPane().add(ponto125);
        ponto125.setBounds(720, 180, 40, 16);

        ponto126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto126.setText("jLabel4");
        getContentPane().add(ponto126);
        ponto126.setBounds(1080, 410, 40, 16);

        ponto127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto127.setText("jLabel4");
        getContentPane().add(ponto127);
        ponto127.setBounds(920, 470, 40, 16);

        ponto128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto128.setText("jLabel4");
        getContentPane().add(ponto128);
        ponto128.setBounds(840, 470, 40, 16);

        ponto129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto129.setText("jLabel4");
        getContentPane().add(ponto129);
        ponto129.setBounds(760, 410, 40, 16);

        ponto130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto130.setText("jLabel4");
        getContentPane().add(ponto130);
        ponto130.setBounds(1040, 410, 40, 16);

        ponto131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto131.setText("jLabel4");
        getContentPane().add(ponto131);
        ponto131.setBounds(990, 380, 40, 16);

        ponto132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto132.setText("jLabel4");
        getContentPane().add(ponto132);
        ponto132.setBounds(800, 410, 40, 16);

        ponto133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto133.setText("jLabel4");
        getContentPane().add(ponto133);
        ponto133.setBounds(760, 380, 40, 16);

        ponto134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto134.setText("jLabel4");
        getContentPane().add(ponto134);
        ponto134.setBounds(840, 410, 40, 16);

        ponto135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto135.setText("jLabel4");
        getContentPane().add(ponto135);
        ponto135.setBounds(880, 410, 40, 16);

        ponto136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto136.setText("jLabel4");
        getContentPane().add(ponto136);
        ponto136.setBounds(920, 410, 40, 16);

        ponto137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto137.setText("jLabel4");
        getContentPane().add(ponto137);
        ponto137.setBounds(960, 410, 40, 16);

        ponto138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto138.setText("jLabel4");
        getContentPane().add(ponto138);
        ponto138.setBounds(1000, 410, 40, 16);

        ponto139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto139.setText("jLabel4");
        getContentPane().add(ponto139);
        ponto139.setBounds(580, 280, 40, 16);

        ponto141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto141.setText("jLabel4");
        getContentPane().add(ponto141);
        ponto141.setBounds(960, 440, 40, 16);

        ponto142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto142.setText("jLabel4");
        getContentPane().add(ponto142);
        ponto142.setBounds(760, 350, 40, 16);

        ponto143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto143.setText("jLabel4");
        getContentPane().add(ponto143);
        ponto143.setBounds(880, 470, 40, 16);

        ponto144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto144.setText("jLabel4");
        getContentPane().add(ponto144);
        ponto144.setBounds(800, 470, 40, 16);

        ponto145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto145.setText("jLabel4");
        getContentPane().add(ponto145);
        ponto145.setBounds(760, 470, 40, 16);

        ponto146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto146.setText("jLabel4");
        getContentPane().add(ponto146);
        ponto146.setBounds(760, 440, 40, 16);

        ponto147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto147.setText("jLabel4");
        getContentPane().add(ponto147);
        ponto147.setBounds(1000, 470, 40, 16);

        ponto148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto148.setText("jLabel4");
        getContentPane().add(ponto148);
        ponto148.setBounds(1040, 470, 40, 16);

        ponto149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto149.setText("jLabel4");
        getContentPane().add(ponto149);
        ponto149.setBounds(1080, 470, 40, 16);

        ponto150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto150.setText("jLabel4");
        getContentPane().add(ponto150);
        ponto150.setBounds(1080, 440, 40, 16);

        ponto151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto151.setText("jLabel4");
        getContentPane().add(ponto151);
        ponto151.setBounds(760, 210, 40, 16);

        ponto152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto152.setText("jLabel4");
        getContentPane().add(ponto152);
        ponto152.setBounds(960, 180, 40, 16);

        ponto153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto153.setText("jLabel4");
        getContentPane().add(ponto153);
        ponto153.setBounds(1000, 180, 40, 16);

        ponto154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto154.setText("jLabel4");
        getContentPane().add(ponto154);
        ponto154.setBounds(880, 180, 40, 16);

        ponto155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto155.setText("jLabel4");
        getContentPane().add(ponto155);
        ponto155.setBounds(840, 180, 40, 16);

        ponto156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pontos.png"))); // NOI18N
        ponto156.setText("jLabel4");
        getContentPane().add(ponto156);
        ponto156.setBounds(920, 180, 40, 16);

        coca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/coquinha.png"))); // NOI18N
        coca.setText("jLabel3");
        getContentPane().add(coca);
        coca.setBounds(690, 350, 20, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo/Fase2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1130, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
    Graphics g = b1.getGraphics();
    g.setColor(Color.BLACK);
    g.fillRect(evt.getX(), evt.getY(), 30, 30); 
    }//GEN-LAST:event_b1MouseClicked

    private void bAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAIMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bAIMouseClicked

    private void bSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bSMouseClicked

    private void b3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b3MouseClicked

    private void bNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bNMouseClicked

    private void bEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bEMouseClicked

    private void b4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b4MouseClicked

    private void b7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b7MouseClicked

    private void b8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b8MouseClicked

    private void b9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b9MouseClicked

    private void b10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b10MouseClicked

    private void b11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b11MouseClicked

    private void b12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b12MouseClicked

    private void b13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b13MouseClicked

    private void b14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b14MouseClicked

    private void b15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b15MouseClicked

    private void b17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b17MouseClicked

    private void b18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b18MouseClicked

    private void b19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b19MouseClicked

    private void b20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b20MouseClicked

    private void b22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b22MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b22MouseClicked

    private void b23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b23MouseClicked

    private void b24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b24MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b24MouseClicked

    private void b25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b25MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b25MouseClicked

    private void b26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b26MouseClicked

    private void b27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b27MouseClicked

    private void b28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b28MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b28MouseClicked

    private void b30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b30MouseClicked

    private void b35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b35MouseClicked

    private void b36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b36MouseClicked

    private void b34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b34MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b34MouseClicked

    private void b2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b2MouseClicked

    private void b37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b37MouseClicked

    private void b38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b38MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b38MouseClicked

    private void b5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b5MouseClicked

    private void b32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b32MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b32MouseClicked

    private void b33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b33MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b33MouseClicked

    private void b21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b21MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaFase2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaFase2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel b1;
    private javax.swing.JPanel b10;
    private javax.swing.JPanel b11;
    private javax.swing.JPanel b12;
    private javax.swing.JPanel b13;
    private javax.swing.JPanel b14;
    private javax.swing.JPanel b15;
    private javax.swing.JPanel b17;
    private javax.swing.JPanel b18;
    private javax.swing.JPanel b19;
    private javax.swing.JPanel b2;
    private javax.swing.JPanel b20;
    private javax.swing.JPanel b21;
    private javax.swing.JPanel b22;
    private javax.swing.JPanel b23;
    private javax.swing.JPanel b24;
    private javax.swing.JPanel b25;
    private javax.swing.JPanel b26;
    private javax.swing.JPanel b27;
    private javax.swing.JPanel b28;
    private javax.swing.JPanel b3;
    private javax.swing.JPanel b30;
    private javax.swing.JPanel b32;
    private javax.swing.JPanel b33;
    private javax.swing.JPanel b34;
    private javax.swing.JPanel b35;
    private javax.swing.JPanel b36;
    private javax.swing.JPanel b37;
    private javax.swing.JPanel b38;
    private javax.swing.JPanel b4;
    private javax.swing.JPanel b5;
    private javax.swing.JPanel b7;
    private javax.swing.JPanel b8;
    private javax.swing.JPanel b9;
    private javax.swing.JPanel bAI;
    private javax.swing.JPanel bE;
    private javax.swing.JPanel bN;
    private javax.swing.JPanel bS;
    private javax.swing.JLabel coca;
    private javax.swing.JLabel fantasma1;
    private javax.swing.JLabel fantasma2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel pacman;
    private javax.swing.JLabel placar;
    private javax.swing.JLabel ponto;
    private javax.swing.JLabel ponto1;
    private javax.swing.JLabel ponto10;
    private javax.swing.JLabel ponto100;
    private javax.swing.JLabel ponto101;
    private javax.swing.JLabel ponto102;
    private javax.swing.JLabel ponto103;
    private javax.swing.JLabel ponto104;
    private javax.swing.JLabel ponto105;
    private javax.swing.JLabel ponto106;
    private javax.swing.JLabel ponto107;
    private javax.swing.JLabel ponto108;
    private javax.swing.JLabel ponto109;
    private javax.swing.JLabel ponto11;
    private javax.swing.JLabel ponto110;
    private javax.swing.JLabel ponto111;
    private javax.swing.JLabel ponto112;
    private javax.swing.JLabel ponto113;
    private javax.swing.JLabel ponto114;
    private javax.swing.JLabel ponto115;
    private javax.swing.JLabel ponto116;
    private javax.swing.JLabel ponto117;
    private javax.swing.JLabel ponto118;
    private javax.swing.JLabel ponto119;
    private javax.swing.JLabel ponto12;
    private javax.swing.JLabel ponto120;
    private javax.swing.JLabel ponto121;
    private javax.swing.JLabel ponto122;
    private javax.swing.JLabel ponto123;
    private javax.swing.JLabel ponto124;
    private javax.swing.JLabel ponto125;
    private javax.swing.JLabel ponto126;
    private javax.swing.JLabel ponto127;
    private javax.swing.JLabel ponto128;
    private javax.swing.JLabel ponto129;
    private javax.swing.JLabel ponto13;
    private javax.swing.JLabel ponto130;
    private javax.swing.JLabel ponto131;
    private javax.swing.JLabel ponto132;
    private javax.swing.JLabel ponto133;
    private javax.swing.JLabel ponto134;
    private javax.swing.JLabel ponto135;
    private javax.swing.JLabel ponto136;
    private javax.swing.JLabel ponto137;
    private javax.swing.JLabel ponto138;
    private javax.swing.JLabel ponto139;
    private javax.swing.JLabel ponto14;
    private javax.swing.JLabel ponto140;
    private javax.swing.JLabel ponto141;
    private javax.swing.JLabel ponto142;
    private javax.swing.JLabel ponto143;
    private javax.swing.JLabel ponto144;
    private javax.swing.JLabel ponto145;
    private javax.swing.JLabel ponto146;
    private javax.swing.JLabel ponto147;
    private javax.swing.JLabel ponto148;
    private javax.swing.JLabel ponto149;
    private javax.swing.JLabel ponto15;
    private javax.swing.JLabel ponto150;
    private javax.swing.JLabel ponto151;
    private javax.swing.JLabel ponto152;
    private javax.swing.JLabel ponto153;
    private javax.swing.JLabel ponto154;
    private javax.swing.JLabel ponto155;
    private javax.swing.JLabel ponto156;
    private javax.swing.JLabel ponto16;
    private javax.swing.JLabel ponto17;
    private javax.swing.JLabel ponto18;
    private javax.swing.JLabel ponto19;
    private javax.swing.JLabel ponto2;
    private javax.swing.JLabel ponto20;
    private javax.swing.JLabel ponto21;
    private javax.swing.JLabel ponto22;
    private javax.swing.JLabel ponto23;
    private javax.swing.JLabel ponto24;
    private javax.swing.JLabel ponto25;
    private javax.swing.JLabel ponto26;
    private javax.swing.JLabel ponto27;
    private javax.swing.JLabel ponto28;
    private javax.swing.JLabel ponto29;
    private javax.swing.JLabel ponto3;
    private javax.swing.JLabel ponto30;
    private javax.swing.JLabel ponto31;
    private javax.swing.JLabel ponto32;
    private javax.swing.JLabel ponto33;
    private javax.swing.JLabel ponto34;
    private javax.swing.JLabel ponto35;
    private javax.swing.JLabel ponto36;
    private javax.swing.JLabel ponto37;
    private javax.swing.JLabel ponto38;
    private javax.swing.JLabel ponto39;
    private javax.swing.JLabel ponto4;
    private javax.swing.JLabel ponto40;
    private javax.swing.JLabel ponto41;
    private javax.swing.JLabel ponto42;
    private javax.swing.JLabel ponto43;
    private javax.swing.JLabel ponto44;
    private javax.swing.JLabel ponto45;
    private javax.swing.JLabel ponto46;
    private javax.swing.JLabel ponto47;
    private javax.swing.JLabel ponto48;
    private javax.swing.JLabel ponto49;
    private javax.swing.JLabel ponto5;
    private javax.swing.JLabel ponto50;
    private javax.swing.JLabel ponto51;
    private javax.swing.JLabel ponto52;
    private javax.swing.JLabel ponto53;
    private javax.swing.JLabel ponto54;
    private javax.swing.JLabel ponto55;
    private javax.swing.JLabel ponto56;
    private javax.swing.JLabel ponto57;
    private javax.swing.JLabel ponto58;
    private javax.swing.JLabel ponto59;
    private javax.swing.JLabel ponto6;
    private javax.swing.JLabel ponto60;
    private javax.swing.JLabel ponto61;
    private javax.swing.JLabel ponto62;
    private javax.swing.JLabel ponto63;
    private javax.swing.JLabel ponto64;
    private javax.swing.JLabel ponto65;
    private javax.swing.JLabel ponto66;
    private javax.swing.JLabel ponto67;
    private javax.swing.JLabel ponto68;
    private javax.swing.JLabel ponto69;
    private javax.swing.JLabel ponto7;
    private javax.swing.JLabel ponto70;
    private javax.swing.JLabel ponto71;
    private javax.swing.JLabel ponto72;
    private javax.swing.JLabel ponto73;
    private javax.swing.JLabel ponto74;
    private javax.swing.JLabel ponto75;
    private javax.swing.JLabel ponto76;
    private javax.swing.JLabel ponto77;
    private javax.swing.JLabel ponto78;
    private javax.swing.JLabel ponto79;
    private javax.swing.JLabel ponto8;
    private javax.swing.JLabel ponto80;
    private javax.swing.JLabel ponto81;
    private javax.swing.JLabel ponto82;
    private javax.swing.JLabel ponto83;
    private javax.swing.JLabel ponto84;
    private javax.swing.JLabel ponto85;
    private javax.swing.JLabel ponto86;
    private javax.swing.JLabel ponto87;
    private javax.swing.JLabel ponto88;
    private javax.swing.JLabel ponto89;
    private javax.swing.JLabel ponto9;
    private javax.swing.JLabel ponto90;
    private javax.swing.JLabel ponto91;
    private javax.swing.JLabel ponto92;
    private javax.swing.JLabel ponto93;
    private javax.swing.JLabel ponto94;
    private javax.swing.JLabel ponto95;
    private javax.swing.JLabel ponto96;
    private javax.swing.JLabel ponto97;
    private javax.swing.JLabel ponto98;
    private javax.swing.JLabel ponto99;
    private javax.swing.JLabel vida1;
    private javax.swing.JLabel vida2;
    private javax.swing.JLabel vida3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
    if (!movimentoContinuoTimer.isRunning()) {
        movimentoContinuoTimer.start();
    }    
        
    int mover = e.getKeyCode();

    int novaPosX = pacman.getX();
    int novaPosY = pacman.getY();

    if (mover == KeyEvent.VK_UP || mover == KeyEvent.VK_W) {
    novaPosY -= 10;
    pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cima.png")));
    ultimaDirecao = 1; 
} else if (mover == KeyEvent.VK_DOWN || mover == KeyEvent.VK_S) {
    novaPosY += 10;
    pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/baixo.png")));
    ultimaDirecao = 2; 
} else if (mover == KeyEvent.VK_LEFT || mover == KeyEvent.VK_A) {
    novaPosX -= 10;
    pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/esquerda.png")));
    ultimaDirecao = 0; 
} else if (mover == KeyEvent.VK_RIGHT || mover == KeyEvent.VK_D) {
    novaPosX += 10;
    pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direita.png")));
    ultimaDirecao = 3; 
}

    if (verificarMovimento(novaPosX, novaPosY)) {
        pacman.setLocation(novaPosX, novaPosY);
    }else {
    movimentoContinuoTimer.stop(); // Para o temporizador se o movimento não for válido
     }

    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
