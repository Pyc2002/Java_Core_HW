package HW_2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final int WIN_COUNT = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static char[][] field; // Игровое поле

    private static final int FIELD_SIZE_X = 5;
    private static final int FIELD_SIZE_Y = 5;


    public static void main(String[] args) {
        while (true){
            initField();
            printField();
            while (true){
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Победил компьютер."))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initField(){


        field = new char[FIELD_SIZE_X][FIELD_SIZE_Y];
        for (int y = 0; y < FIELD_SIZE_X; y++){
            for (int x = 0; x < FIELD_SIZE_Y; x++){
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Распечатать игровое поле
     */
    private static void printField(){
        System.out.print("+");
        for (int i = 0; i < FIELD_SIZE_X; i++){
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int y = 0; y < FIELD_SIZE_Y; y++){
            System.out.print((y + 1) + "|");
            for (int x = 0; x < FIELD_SIZE_X; x++){
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < FIELD_SIZE_X*2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    private static void humanTurn(){
        int x, y;

        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до " + FIELD_SIZE_X + ") через пробел >>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;

    }

    /** TODO: 3. Компьютер должен мешать игроку
     * Ход игрока (компьютер)
     */
//    private static void aiTurn() {
////        for (int y = 0; y < FIELD_SIZE_Y; y++) {
////            for (int x = 0; x < FIELD_SIZE_X; x++) {
//////                if (!isCellEmpty(x, y)) {
////                    if (check1(x, y, DOT_HUMAN, WIN_COUNT - 2) && x + (WIN_COUNT-2)< FIELD_SIZE_X
////                            && isCellEmpty(x + (WIN_COUNT-2), y)){
////                        field[y][x + WIN_COUNT-2 ] = DOT_AI;
////                    }
//////                    else if (check2(x, y, DOT_HUMAN, WIN_COUNT - 1)) {
//////                        field[y + 1][x] = DOT_AI;
//////                    } else if (check3(x, y, DOT_HUMAN, WIN_COUNT - 1)) {
//////                        field[y + 1][x + 1] = DOT_AI;
//////                    } else if (check4(x, y, DOT_HUMAN, WIN_COUNT - 1)) {
//////                        field[y - 1][x + 1] = DOT_AI;
//////                    }
//////                    else {
//////                        field[random.nextInt(FIELD_SIZE_Y)][random.nextInt(FIELD_SIZE_X)] = DOT_AI;
//////                    }
////                }
//////            }
////        }
////    }
//
//        for (int y = 0; y < FIELD_SIZE_Y; y++) {
//            for (int x = 0; x < FIELD_SIZE_X; x++) {
//                do {
//                    if (isCellEmpty(x, y)) field[y][x] = DOT_HUMAN;
//                } while (check1(x, y, DOT_HUMAN, WIN_COUNT - 1));
//            }
//        }
//
//    }



    private static void aiTurn(){
        int x, y;
        do {
            x = random.nextInt(FIELD_SIZE_Y);
            y = random.nextInt(FIELD_SIZE_Y);
        }
        while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }


    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y){
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка корректности координат хода
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < FIELD_SIZE_X && y >= 0 && y < FIELD_SIZE_Y;
    }

    /**
     * Метод проверки состояния игры
     * @param dot фишка игрока
     * @param winStr победный слоган
     * @return признак завершения игры (true)
     */
    private static boolean gameCheck(char dot, String winStr){
        if (checkWin(dot)){
            System.out.println(winStr);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью (все ячейки игрового поля заполнены)
     * @return
     */
    private static boolean checkDraw(){
        for (int y = 0; y < FIELD_SIZE_Y; y++){
            for (int x = 0; x < FIELD_SIZE_X; x++){
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * TODO: 2. Переработать в рамках домашней работы, метод должен быть универсальным
     * Проверка победы
     * @param dot фишка игрока (X или 0)
     * @return
     */
    private static boolean checkWin(char dot){
        for (int y = 0; y < FIELD_SIZE_Y; y++){
            for (int x = 0; x < FIELD_SIZE_X; x++){
                if (check1(x,y,dot, WIN_COUNT) || check2(x,y,dot, WIN_COUNT) || check3(x,y,dot, WIN_COUNT) || check4(x,y,dot, WIN_COUNT))
                    return true;
            }
        }
        return false;
    }

    /**
     * Проверка по горизонтали
     * @param x, y - координаты
     * @param dot фишка игрока (X или 0)
     * @return
     */

    private static boolean check1(int x, int y, char dot, int winCount) {
        int count = 0;
        for (int i = 0; i < winCount; i++) {
            if (x + i < FIELD_SIZE_X && field[y][x + i] == dot) count++;
        }
        if (count == winCount) return true;

        return false;
    }

    /**
     * Проверка по вертикали
     * @param x, y - координаты
     * @param dot фишка игрока (X или 0)
     * @return
     */

    private static boolean check2(int x, int y, char dot, int winCount){
        int count = 0;
        for (int i = 0; i < winCount; i++) {
            if (y + i < FIELD_SIZE_Y && field[y+i][x] == dot) count++;
        }
        if (count == winCount) return true;

        return false;
    }

    /**
     * Проверка по диагонали вниз вправо
     * @param x, y - координаты
     * @param dot фишка игрока (X или 0)
     * @return
     */
    private static boolean check3(int x, int y, char dot, int winCount){
        int count = 0;
        for (int i = 0; i < winCount; i++) {
            if (x + i < FIELD_SIZE_X && y + i < FIELD_SIZE_Y && field[y+i][x+i]==dot) count++;
        }
        if (count == winCount) return true;
        return false;
    }

    /**
     * Проверка по диагонали вверх вправо
     * @param x, y - координаты
     * @param dot фишка игрока (X или 0)
     * @return
     */

    private static boolean check4(int x, int y, char dot, int winCount){
        int count = 0;
        for (int i = 0; i < winCount; i++) {
            if (x + i < FIELD_SIZE_X && y - i >= 0 && field[y-i][x+i]==dot) count++;
        }
        if (count == winCount) return true;
        return false;

    }

}

