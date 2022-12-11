import java.util.Arrays;


public class Tasks6 {
    public static void main(String[] args){
        System.out.println("Задача 1");
        System.out.println("bell(1) = " + bell(1));
        System.out.println("bell(2) = " + bell(2));
        System.out.println("bell(3) = " + bell(3));
        System.out.println("\nЗадача 2");
        System.out.println("translateWord(\"flag\") = " + translateWord("flag"));
        System.out.println("translateWord(\"Apple\") = " + translateWord("apple"));
        System.out.println("translateWord(\"button\") = " + translateWord("button"));
        System.out.println("translateWord(\"\"); = " + translateWord(""));
        System.out.println("translateSentence(\"I like to eat honey waffles.\") = " + translateSentence("I like to eat honey waffles."));
        System.out.println("\nЗадача 3");
        System.out.println("validColor(\"rgb(0,0,0)\") = " + validColor("rgb(0,0,0)"));
        System.out.println("validColor(\"rgb(0,,0)\") = " + validColor("rgb(0,,0)"));
        System.out.println("validColor(\"rgb(255,256,255)\") = " + validColor("rgb(255,256,255)"));
        System.out.println("validColor(\"rgba(0,0,0,0.123456789)\") = " + validColor("rgba(0,0,0,0.123456789)"));
        System.out.println("\nЗадача 4");
        System.out.println("stripUrlParams(\"https://edabit.com?a=1&b=2&a=2\") = " + stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println("stripUrlParams(\"https://edabit.com?a=1&b=2&a=2\" ,[\"b\"]) = " + stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        System.out.println("stripUrlParams(\"https://edabit.com\", [\"b\"]) = " + stripUrlParams("https://edabit.com", new String[]{"b"}));
        System.out.println("\nЗадача 5");
        System.out.println("getHashTags(\"How the Avocado Became the Fruit of the Global Trade\") = " + Arrays.toString(getHashTags("How the Avocado Became the Fruit of the Global Trade")));
        System.out.println("getHashTags(\"Why You Will Probably Pay More for Your Christmas Tree This Year\") = " + Arrays.toString(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year")));
        System.out.println("getHashTags(\"Hey Parents, Surprise, Fruit Juice Is Not Fruit\") = " + Arrays.toString(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit")));
        System.out.println("getHashTags(\"Visualizing Science\") = " + Arrays.toString(getHashTags("Visualizing Science")));
        System.out.println("\nЗадача 6");
        System.out.println("ulam(4) = " + ulam(4));
        System.out.println("ulam(9) = " + ulam(9));
        System.out.println("ulam(206) = " + ulam(206));
        System.out.println("\nЗадача 7");
        System.out.println("longestNonrepeatingSubstring(\"abcabcbb\") = " + longestNonrepeatingSubstring("abcabcbb"));
        System.out.println("longestNonrepeatingSubstring(\"aaaaaa\") = " + longestNonrepeatingSubstring("aaaaaa"));
        System.out.println("longestNonrepeatingSubstring(\"abcde\") = " + longestNonrepeatingSubstring("abcde"));
        System.out.println("longestNonrepeatingSubstring(\"abcda\") = " + longestNonrepeatingSubstring("abcda"));
        System.out.println("\nЗадача 8");
        System.out.println("convertToRoman(2) = " + convertToRoman(2));
        System.out.println("convertToRoman(12) = " + convertToRoman(12));
        System.out.println("convertToRoman(16) = " + convertToRoman(16));
        System.out.println("\nЗадача 9");
        System.out.println("formula(\"6 * 4 = 24\") = " + formula("6 * 4 = 24"));
        System.out.println("formula(\"18 / 17 = 2\") = " + formula("18 / 17 = 2"));
        System.out.println("formula(\"16 * 10 = 160 = 14 + 120\") = " + formula("16 * 10 = 160 = 14 + 120"));
        System.out.println("\nЗадача 10");
        System.out.println("palindromedescendant(11211230) = " + palindromedescendant(11211230));
        System.out.println("palindromedescendant(13001120) = " + palindromedescendant(13001120));
        System.out.println("palindromedescendant(23336014) = " + palindromedescendant(23336014));
        System.out.println("palindromedescendant(11) = " + palindromedescendant(1211));
    }


    /** Функция, возвращающая соответсвующее число Белла для числа n */
    public static int bell(int n){
        //Двумерный массив для хранения треугольника Белла по слоям
        int[][] bell = new int[n+1][n+1];
        //Треугольник начинается с 1
        bell[0][0] = 1;
        /*
        * Треугольник заполняется по слоям так, что первый элемент нового слоя
        * равен последнему предыдушего, а следующий, например под слоем i и горизонтальным индексом j равен bell[i][j - 1] + bell[i - 1][j - 1]
        * 1
        * 1 2
        * 2 3 5
        * 5 7 10 15
        * 15 20 27 37 52
        */
        for (int i = 1; i <= n; i++) {
            bell[i][0] = bell[i-1][i-1];
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i-1][j-1] + bell[i][j-1];
            }
        }
        //Следовательно первый элемент последнего слоя и есть ответ
        return bell[n][0];
    }

    /** Функция для перевода слова в свиную латынь*/
    public static String translateWord(String word){
        if(word.length() == 0)return "";
        //Константы гласных, согласных и всех разрешённых символов.
        String vowels = "aeiouyAEIOUY";
        String consonants = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
        String allowedSymbols = consonants + vowels;

        //Процесс нахождения конца слова в строке, т.к. кроме слова в строке могут присутствовать знаки препринания.
        int endIdx = word.length();
        while(allowedSymbols.indexOf(word.charAt(endIdx - 1))== -1)endIdx--;

        //Проверка на что начинаестя слово: согласные/гласные.
        if(vowels.indexOf(word.charAt(0)) == -1){
            //Обрезка первой буквы слова добавление его в конец вместе с "ay", а затем остальной части строки.
            return word.substring(1, endIdx) + word.charAt(0) + "ay" + word.substring(endIdx);
        } else {
            //Обрезка слова в строке , добавление "yay", а затем остальной части строки.
            return word.substring(0, endIdx) + "yay" + word.substring(endIdx);
        }
    }

    /** Функция для перевода предложения в свиную латынь */
    public static String translateSentence(String sentence){
        //Разбиваем строку на слова по пробелам
        String[] words = sentence.split(" ");

        //Применяем функцию перевода слова к каждому слову в массиве
        for(int i = 0; i < words.length; i++){
            words[i] = translateWord(words[i]);
        }
        return String.join(" ", words);
    }

    /** Функция проверяет на валидность строку содержащую цвет в формате RGB/RGBA */
    public static boolean validColor(String color){
        //Проверка содержит ли строка "rgb".
        if(!color.contains("rgb"))return false;
        boolean isRgba = false;
        //Проверка строка содержит "rgb" или "rgba"?. и затем обрезка этой части строки
        if(color.contains("rgba")){
            isRgba = true;
            color = color.substring(4);
        } else {
            color = color.substring(3);
        }
        //Проверка строки на наличие скобок и затем обрезка их.
        if(color.charAt(0) != '(' || color.charAt(color.length() - 1) != ')')return false;
        color = color.substring(1, color.length() - 1);

        //Разбка оставшихся чисел на массив строк.
        String[] numbers = color.split(",");

        //Проверка на то что цвет не в формате RGBA, а чисел не три.
        if(!isRgba && numbers.length != 3)return false;

        //Попытка спарсить три первых числа и сразу проверка на то, что они в интервале [0, 255].
        for(int i = 0; i < 3; i++){
            try{
                int num = Integer.parseInt(numbers[i]);
                if(num < 0 || num > 255)return false;
            } catch (NumberFormatException e){
                return false;
            }
        }
        //Когда цвет в формате RGBA пытаемся спарсить и проверить четвёртое дробное число на интервал [0, 1.0].
        if(numbers.length == 4){
            try{
                double num = Double.parseDouble(numbers[3]);
                if(num < 0 || num > 1)return false;
            } catch (NumberFormatException e){
                return false;
            }
        }
        return true;
    }

    /** Фукнция для исключения повторяющихся параметров из строки URL, а также для удаления исключённых параметров*/
    public static String stripUrlParams(String url, String[] ...paramsToStrip){
        //Узнаём где у нас в строке '?' слева получается чистый url, справа параметры
        int askIdx = url.indexOf('?');
        String exc = "";
        //Если параметров нет, то ответом будет url
        if(askIdx == -1)return url;

        //Проверяем на параметры исключения
        int paramsLength = paramsToStrip.length;
        if(paramsLength != 0){
            //Если они есть, то их длина должна равнятся 1
            if(paramsLength > 1) return "Error";
            //Получаем параметры и объединяем их в строку
            exc = String.join("", paramsToStrip[0] );
        }
        //Получаем чистый url
        String cleanUrl = url.substring(0, askIdx);
        //Получаем параметры разбивая правую часть строки по '&'
        String[] params = url.substring(askIdx + 1).split("&");
        StringBuilder usedParams = new StringBuilder(",");
        usedParams.append(exc).append(",");
        StringBuilder answer = new StringBuilder();
        //Итерируем по параметрам
        String[] param;
        String paramWord;
        int paramVal;
        for(int i = (params.length - 1); i > -1; i--){
            param = params[i].split("=");
            paramWord = param[0];
            //Если параметр уже в строке или он в исключениях, то пропускаем его
            int paramWordIdx = usedParams.indexOf(paramWord);
            if(paramWordIdx != -1){
                if(usedParams.charAt(paramWordIdx - 1) == ',' && usedParams.charAt(paramWordIdx + paramWord.length()) == ',')continue;
            }
            String toFind = paramWord + "=";
            int counter = params.length - 1;
            int paramIdx = params[params.length - 1].indexOf(toFind);
            while(counter > -1 && paramIdx != 0){
                paramIdx = params[counter].indexOf(toFind);
                counter--;
            }
            try{
                paramVal = Integer.parseInt(params[counter].substring(paramIdx + toFind.length()));
            } catch (NumberFormatException e){
                return "Error";
            }
            if(i == 0)answer.append("?");
            else answer.append("&");
            answer.append(paramWord).append("=").append(paramVal);
            usedParams.append(paramWord).append(",");
        }
        answer.insert(0, cleanUrl);
        return answer.toString();
    }

    /** Функция возвращает слово, находящееся в строке */
    public static String findWord(String word){
        String allowed = "qwertyuiopasdfghjklzxcvbnm";
        int wordLength = word.length();
        String lowerWord = word.toLowerCase();
        int lIdx = 0; int rIdx = wordLength - 1;
        while(allowed.indexOf(lowerWord.charAt(rIdx))== -1 && rIdx > -1)rIdx--;
        while(allowed.indexOf(lowerWord.charAt(lIdx))== -1 && lIdx < wordLength)lIdx++;
        return word.substring(lIdx, rIdx + 1);
    }

    /** Функция возвращает три слова максимальной длины в нижнем регистре */
    public static String[] getHashTags(String seq){
        int MAX_WORDS_COUNT = 3;
        String[] words = seq.split(" ");
        int len = words.length;
        //Если слов не больше трёх, то возвращаем их
        if(len == 0)return new String[0];
        if(len == 1)return new String[]{"#" + words[0].toLowerCase()};
        if(len == 2)return new String[]{"#" + words[0].toLowerCase(), "#" + words[1].toLowerCase()};
        //Храним три больших слова
        String[] maxWords = new String[MAX_WORDS_COUNT];
        for(int i = 0; i < MAX_WORDS_COUNT; i++){
            maxWords[i] = "";
        }
        //Итерируем в цикле
        for (String word : words) {
            word = findWord(word).toLowerCase();
            //Если слово больше первого по величине, то сдвигаем остальные слова и записываем новое
            if (word.length() > (maxWords[0].length() - 1)) {
                maxWords[2] = maxWords[1];
                maxWords[1] = maxWords[0];
                maxWords[0] = "#" + word;
                //Если слово больше второго, то сдвигаем слово после него и записываем новое
            } else if (word.length() > (maxWords[1].length() - 1)) {
                maxWords[2] = maxWords[1];
                maxWords[1] = "#" + word;
                //Если слово меньше третьего, то записываем туда новое.
            } else if (word.length() > (maxWords[2].length() - 1)) {
                maxWords[2] = "#" + word;
            }
        }
        return maxWords;
    }

    /** Функция находящая n-ое число последовательности улама */
    public static int ulam(int n){
        //Если число меньше трёх, то возвращаем его значение
        if(n < 1)return 0;
        if(n == 1)return 1;
        if(n == 2)return 2;
        //Создаём массив для хранения чисел улама
        int[] ulamSeq = new int[n];
        //Вносим первые элементы
        ulamSeq[0] = 1;
        ulamSeq[1] = 2;
        int ulamSeqIdx = 2;
        int ulamNum = 3;
        //Так как сумма всегда возрастает от числа к числу(Далее СЧУ), то мы перебираем последовательно все числа от 3 до n.
        //Итерируем в цикле пока номер числа улана не будет n
        while(ulamSeqIdx < n){
            //Считаем сколькими способами можно представить СЧУ.
            int counter = 0;
            for(int i = 0; i < ulamSeqIdx; i++){
                for(int j = i + 1; j < ulamSeqIdx; j++){
                    if(ulamSeq[i] + ulamSeq[j] == ulamNum)counter++;
                }
            }
            //Если способ один, то это число улама, записываем число в массив и увеличиваем индекс
            if(counter == 1){
                ulamSeq[ulamSeqIdx] = ulamNum;
                ulamSeqIdx++;
            }
            //Увеличиваем СЧУ
            ulamNum++;
        }
        return ulamSeq[n - 1];
    }

    /** Функция, находящая самую длинную, неповторяющуюся символьную последовательность в строке */
    public static String longestNonrepeatingSubstring(String seq){
        int seqLength = seq.length();
        if(seqLength == 0)return "";
        if(seqLength == 1)return seq;
        //Инициализация переменных максимальной длины последовательности и индекса её начала
        int maxLen = 1;
        int maxIdx = 0;
        //Инициализация переменных текущей длины последовательности и индекса её начала
        int currLen = 1;
        int currIdx = 0;
        StringBuilder usedChars = new StringBuilder();
        usedChars.append(seq.charAt(0));
        for(int i = 1; i < seqLength; i++){
            //Получаем индекс текущего итерируемого символа
            int charIdx = usedChars.indexOf(String.valueOf(seq.charAt(i)));
            //Если его нет в сохранённой последовательности, то добавляем его туда и идём дальше
            if(charIdx == -1){
                currLen++;
                usedChars.append(seq.charAt(i));
            } else {
                //Если же он там есть, то уникальная последовательность закончилась, и мы сохраняем максимальную из них
                if(currLen > maxLen){
                    maxLen = currLen;
                    maxIdx = currIdx;
                }
                currLen = 1;
                currIdx = i;
                usedChars = new StringBuilder();
                usedChars.append(seq.charAt(i));
            }
        }
        //Последняя проверка, т.к. последовательность может закончиться в конце строки
        if(currLen > maxLen){
            maxLen = currLen;
            maxIdx = currIdx;
        }
        return seq.substring(maxIdx, maxIdx + maxLen);
    }

    /** Функция для перевода числа в строку римских цифр */
    public static String convertToRoman(int num){
        if(num < 1 || num > 3999)return "Error";
        StringBuilder answer = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        //Итерируем по массиву чисел кратным римским, дальше ЧТР
        while(num > 0){
            /*
            * Если число больше текущего ЧТР, то римское число по ЧТР добавляется в строку, а
            * из числа вычитается ЧТР, если же число меньше ЧТР, то переходим к следующему ЧТР
            */
            if(num >= nums[i]){
                answer.append(romans[i]);
                num -= nums[i];
            } else i++;
        }
        return answer.toString();
    }

    /** Функция решает простейшие математические выражения путём обращения в рекурсию при каждой новой операции */
    public static int solvePart(String part){
        String operations = "+-*/";
        int idx = 0;
        while(idx < part.length() && operations.indexOf(part.charAt(idx)) == -1)idx++;
        if(idx == part.length())return Integer.parseInt(part.strip());
        char operation = part.charAt(idx);
        return switch (operation) {
            case '+' -> solvePart(part.substring(0, idx)) + solvePart(part.substring(idx + 1));
            case '-' -> solvePart(part.substring(0, idx)) - solvePart(part.substring(idx + 1));
            case '*' -> solvePart(part.substring(0, idx)) * solvePart(part.substring(idx + 1));
            case '/' -> solvePart(part.substring(0, idx)) / solvePart(part.substring(idx + 1));
            default -> 0;
        };
    }

    /** Функция проверяет строку с формулой на математическую достоверность*/
    public static boolean formula(String form){
        //Проверяем есть ли '=' в строке
        int equalsIdx = form.indexOf("=");
        if(equalsIdx == -1)return false;
        //Проверяем больше ли одного "=" в строке
        if(form.indexOf("=", equalsIdx + 1) != -1)return false;
        //Разбиваем строку на две части по "="
        String[] parts = form.split("=");
        //Если "=" в начале или конце строки, то формула неверна
        if(parts.length != 2)return false;
        //Получаем вычисленные части формулы
        int leftPart = solvePart(parts[0]);
        int rightPart = solvePart(parts[1]);
        //Сравниваем их
        return leftPart == rightPart;
    }

    /** Функция проверяет является ли строка, содержащая чётное число, палиндромом */
    public static boolean isPalindrome(String palindrome){
        if(palindrome.length() == 0)return false;
        if(palindrome.length() % 2 != 0)return false;
        return palindrome.substring(0, palindrome.length() / 2).equals(new StringBuilder(palindrome.substring(palindrome.length() / 2)).reverse().toString());
    }

    /** Функция проверяет является ли число или его потомок палиндромом */
    public static boolean palindromedescendant(int digit){
        //Преобразуем число в строку
        String num = String.valueOf(digit);
        //Если строка нечётная длиной, то уже неверно
        if(num.length() % 2 != 0)return false;
        StringBuilder nw = new StringBuilder();
        //Цикл по строке
        while(num.length() > 1){
            //Проверка на палиндром
            if(isPalindrome(num))return true;
            //Итерация по числу с шагом 2
            for(int i = 0; i < num.length() / 2; i++){
                //Получаем левую цифру при шаге 2
                int first = Character.getNumericValue(num.charAt(i * 2));
                //Получаем правую цифру при шаге 2
                int second = Character.getNumericValue(num.charAt(i * 2 + 1));
                //Добавляем новое число в строку
                nw.append(first + second);
            }
            //Переносим получившуюся строку в num
            num = nw.toString();
            //Очищаем строку
            nw = new StringBuilder();
        }
        return false;
    }
}
