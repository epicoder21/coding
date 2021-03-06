package stuff;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CanvasPanel extends JPanel {
    BufferedImage North = null;
    BufferedImage South = null;
    BufferedImage East = null;
    BufferedImage West = null;
    BufferedImage img = null;
    BufferedImage timesTwo = null;
    BufferedImage watermelon = null;
    boolean canGoSouth = true;
    boolean canGoNorth = true;
    boolean canGoWest = true;
    boolean canGoEast = true;
    boolean removeTail = true;
    boolean isthereMulti = false;
    boolean eatenMulti = false;
    int score = 0;
    int[][] data = new int[20][20];
    int direct = 0;//zero is south, 1 is east, 2 is west 3 is north
    int gridLength = data.length;
    int highscore = score;
    int cellWidth = 35;

//    int CurrX = 1;
//    int CurrY = 1;

    java.util.List<int[]> snake = new ArrayList<>();

    public CanvasPanel() {
        try {
            img = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("apple.png").openStream());

            timesTwo = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("timestwomultiplier.jpg").openStream());

            watermelon = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("watermelon.jpg").openStream());

            North = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("north.png").openStream());

            East = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("east.png").openStream());

            South = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("south.png").openStream());

            West = ImageIO.read(CanvasPanel.class.getClassLoader().getResource("west.png").openStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

        init();
    }

    public void init() {
        snake = new ArrayList<>();
        snake.add(new int[]{10,10});
        snake.add(new int[]{10,9});
        snake.add(new int[]{10,8});
        snake.add(new int[]{10,7});
        data = new int[20][20];
        data[10][10] = 1;
        data[10][9] = 1;
        data[10][8] = 1;
        data[10][7] = 1;
        this.randomApple(4);
        this.randomMelon(1);
        this.randomMultiplier(1);
        score = 0;
    }


    public void playsound(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResource("apple.wav")).openStream());
            Clip clip;
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


    }
    public void playsoundDeath(){
        try {
            AudioInputStream audioInputOOf = AudioSystem.getAudioInputStream(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResource("classic_hurt.wav")).openStream());
            Clip oof;
            oof = AudioSystem.getClip();
            oof.open(audioInputOOf);
            oof.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }


    }

    Font big;
    public void randomApple(int numApp) {
        for (int a = 0; a < numApp; a++) {
            int appX = (int)(Math.random()*gridLength);
            int appY = (int)(Math.random()*gridLength);
            if (data[appX][appY]==1 || data[appX][appY]==3 || data[appX][appY] == 2 || data[appX][appY] == 4){
                data[(int)(Math.random() * gridLength)][(int)(Math.random() * gridLength)]=3;
            } else {
                data[appX][appY] = 3;
            }
        }

    }

    public void randomMelon(int numMelon) {
        for (int m = 0; m < numMelon; m++) {
            int melX = (int)(Math.random()*gridLength);
            int melY = (int)(Math.random()*gridLength);
            if (data[melX][melY]==1 || data[melX][melY]==3 || data[melX][melY] == 2 || data[melX][melY] == 4){
                data[(int)(Math.random() * (gridLength))][(int)(Math.random() * (gridLength))]=2;
            } else {
                data[melX][melY] = 2;
            }
        }

    }

    public void randomMultiplier(int numMulti) {
        for (int M = 0; M < numMulti; M++) {
            int randomizer = (int) (Math.random()*100);
            if (randomizer <= 15) {
                int mulX = (int)(Math.random()*gridLength);
                int mulY = (int)(Math.random()*gridLength);
                isthereMulti = true;
                if (data[mulX][mulY]==1 || data[mulX][mulY]==3 || data[mulX][mulY] == 2 || data[mulX][mulY] == 4){
                    data[(int)(Math.random() * (gridLength))][(int)(Math.random() * (gridLength))]=4;
                } else {
                    data[mulX][mulY] = 4;
                }
            }
        }
    }

    Font last;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        last = g.getFont();
//1 = snake body, 0 = empty cell, 3 = apple, 2 = watermelon
        for (int i = 0; i < data.length; i++) {
            for(int j = 0; j < data.length; j++) {
                if (data[i][j] == 1) {
                    if(snake.get(0)[0] == i && snake.get(0)[1] == j) {
                        //zero is south, 1 is east, 2 is west 3 is north
                        if (direct == 3) {
                            g.drawImage(North, i * cellWidth, j
                                    * cellWidth, cellWidth, cellWidth, null);
                        } else if (direct == 2) {
                            g.drawImage(East, i * cellWidth, j
                                    * cellWidth, cellWidth, cellWidth, null);
                        } else if (direct == 1) {
                            g.drawImage(West, i * cellWidth, j
                                    * cellWidth, cellWidth, cellWidth, null);
                        } else if (direct == 0) {
                            g.drawImage(South, i * cellWidth, j
                                    * cellWidth, cellWidth, cellWidth, null);
                        }
                    } else {
                        g.setColor(Color.green);
                        g.fillRect(i*cellWidth,j*cellWidth, cellWidth,cellWidth);
                    }
                } else if(data[i][j] == 0){
                    g.setColor(Color.black);
                    g.drawRect(i*cellWidth, j*cellWidth, cellWidth, cellWidth);
                } else if(data[i][j] == 3){
                    g.setColor(Color.black);
                    g.drawRect(i*cellWidth, j*cellWidth, cellWidth, cellWidth);

                    g.drawImage(img, i * cellWidth, j
                            * cellWidth, cellWidth, cellWidth, null);
                } else if(data[i][j] == 2){
                    g.drawImage(watermelon, i * (cellWidth), j
                            * (cellWidth), cellWidth, cellWidth, null);

                    g.setColor(Color.black);
                    g.drawRect(i*cellWidth, j*cellWidth, cellWidth, cellWidth);
                }else if(data[i][j] == 4){
                    g.drawImage(timesTwo, i * (cellWidth), j
                            * (cellWidth), cellWidth, cellWidth, null);

                    g.setColor(Color.black);
                    g.drawRect(i*cellWidth, j*cellWidth, cellWidth, cellWidth);
                }
            }
        }
        if (MyMain.onGame == 0) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            big = g.getFont();
            g.drawString("Press Space to start", 350, 375);
            g.setFont(last);
        } else if (MyMain.onGame == 2 ){
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            g.drawString("Game Over", 350, 375);
            g.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g.drawString("Your score was:" + score, 350, 345);
            g.drawString("Highscore:" + highscore, 350, 315);
            g.setFont(last);
        }
        g.setFont(new Font("TimesRoman", Font.BOLD, 30));
        g.drawString("Score = " + score, 495, 750);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        g.drawString("Highscore:" + highscore, 495, 800);
        g.setFont(last);

        if (MyMain.onGame == 0 || MyMain.onGame == 2) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            big = g.getFont();
            g.drawString("Speed = 0", 890, 700);
            g.setFont(last);
        } else if (MyMain.onGame == 1 ){
            g.setFont(new Font("TimesRoman", Font.BOLD, 30));
            big = g.getFont();
            g.drawString("Speed = " + MyMain.speed, 890, 700);
            g.setFont(last);
        }
        //difficulty
        if (MyMain.difficulty == 0) {
            g.setFont(new Font("TimesRoman", Font.BOLD, 45));
            big = g.getFont();
            g.drawString("Easy Mode", 800, 650);
            g.setFont(last);
        } else if (MyMain.difficulty == 1 ){
            g.setFont(new Font("TimesRoman", Font.BOLD, 45));
            big = g.getFont();
            g.drawString("Medium Mode" , 800, 650);
            g.setFont(last);
        } else if (MyMain.difficulty == 2)
            g.setFont(new Font("TimesRoman", Font.BOLD, 45));
        big = g.getFont();
        g.drawString("Hard Mode" , 800, 650);
        g.setFont(last);

    }

    public void movegame() {
        if (MyMain.onGame == 2 || MyMain.onGame == 0) {
            return;
        }
//zero is south, 1 is east, 2 is west 3 is north
        int CurrX = snake.get(0)[0];
        int CurrY = snake.get(0)[1];
//        data[CurrX][CurrY] = 0;
        if (direct == 3) {
            CurrY = CurrY - 1;
            canGoSouth = false;
            canGoEast = true;
            canGoWest = true;
        }
        if (direct == 2) {
            CurrX = CurrX + 1;
            canGoEast = false;
            canGoNorth = true;
            canGoSouth = true;
        }
        if (direct == 0) {
            CurrY = CurrY + 1;
            canGoNorth = false;
            canGoEast = true;
            canGoWest = true;
        }
        if (direct == 1) {
            CurrX = CurrX -1;
            canGoWest = false;
            canGoNorth = true;
            canGoSouth = true;
        }
        if (CurrY == 20 || CurrX == 20 || CurrX == -1 || CurrY == -1) {
            MyMain.onGame = 2;
            playsoundDeath();
            return;
        }
        removeTail = true;

        if(data[CurrX][CurrY] == 3) {
            score += 1;
            if (score > highscore) {
                highscore = score;
            }
            this.randomApple(1);
            if (isthereMulti == false) {
                this.randomMultiplier(1);
            }
            removeTail = false;
            playsound();
        }
        if(data[CurrX][CurrY] == 2) {
            score += 3;
            if (score > highscore) {
                highscore = score;
            }
            this.randomMelon(1);
            if (isthereMulti == false) {
                this.randomMultiplier(1);
            }
            removeTail = false;
            playsound();
        }
        if(data[CurrX][CurrY] == 4) {
            eatenMulti = true;
        }
        int spawnExtraApp;
//        if (MyMain.onGame == 1) {
//            for (int boardLength = 0; boardLength <= 20; boardLength++) {
//                for (int boardLength2 = 0; boardLength2 <= 20; boardLength2++) {
//                    if (data[boardLength][boardLength2] == 2) {
//                        MyMain.waterCount = MyMain.waterCount + 1;
//                    }
//                    if (data[boardLength][boardLength2] == 3) {
//                        MyMain.appCount = MyMain.appCount + 1;
//                    }
//                }
//            }
//            if (MyMain.waterCount != 1) {
//             randomMelon(1);
//            }
//            if (MyMain.appCount != 4) {
//                spawnExtraApp = 4 - MyMain.appCount;
//                randomMelon(spawnExtraApp);
//            }
//        }

        if (data[CurrX][CurrY] == 1) {
            MyMain.onGame = 2;
            playsoundDeath();
            return;
        }

        if (removeTail == true) {
            int[] tailPosition = snake.get(snake.size() - 1);

            data[tailPosition[0]][tailPosition[1]] = 0;
            //old tail remove
            snake.remove(snake.size() - 1);
            // data[position] = 0
            // snake.remove(tail)
        }


        // new head add it to snake.
        //  new headposition,
        int[] newHead = new int[]{CurrX, CurrY};
        snake.add(0, newHead);
        data[CurrX][CurrY] = 1;
    }
}
