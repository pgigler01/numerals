/*
 * Copyright (C) 2011 Vit <vitalker@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.programmisty.numerals;

import java.math.BigDecimal;
/**
 * 
 * <pre>
 *  import java.math.BigDecimal;
 *  import java.math.BigInteger;
 *  import static com.programmisty.numerals.Numerals.*;
 *  public class Sample {
 *
 *     public static void main(String[] args) {
 *      //one hundred twenty-three
 *      System.out.println(english(123));
 *
 *      //one hundred twenty-three thousand four hundred fifty-six
 *      System.out.println(english(new BigInteger("123456")));
 * 
 *      //Ninety-nine and 89/100
 *      System.out.println(amount(new BigDecimal("99.89")));
 *   }
 * }
 * </pre>
 * @author vit
 */
public class Numerals {

    /**
     * Number in word in english.
     * Sample:
     * <pre>
     *   Numerals.english(123); // one hundred twenty-three
     * </pre>
     *
     * Supported only integer numbers: Integer, Long, Short, Byte, BigInteger
     * Max supported number: 1000000000000000000000000000000000000-1
     * 
     * @param number 
     * @return
     */
    public static String english(Number n) {
        return new English().format(n);
    }

    /**
     * Number in word in russian.
     * Число прописью по-русски.
     * Sample:
     * <pre>
     *   Numerals.russian(123); // семьсот семьдесят семь
     * </pre>
     *
     * Supported only integer numbers: Integer, Long, Short, Byte, BigInteger
     * Max supported number: 1000000000000000000000000000000000000-1
     *
     * @param number
     * @return
     */
    public static String russian(Number n) {
        return new Russian().format(n);
    }

    /**
     * Amount in words. English. Sometimes useful in payment docs.
     * <pre>
     *  BigDecimal x = new BigDecimal("99.89");
     *  Numerals.amount(x); // Ninety-nine and 89/100
     * </pre>
     * @param n
     * @return
     */
    public static String amount(Number n) {
        BigDecimal bd = Util.toBigDecimal(n);
        return new English().amount(bd);
    }

    /**
     * Amount in words. Russian. Sometimes useful in finan docs.
     * Сумма прописью. Бывает используются в разных платежных документах.
     * 
     * <pre>
     *  BigDecimal x = new BigDecimal("777.77");
     *  Numerals.russianRubles(x); // Семьсот семьдесят семь рублей 77 копеек
     * </pre>
     * @param n
     * @return
     */
    public static String russianRubles(Number n) {
        BigDecimal bd = Util.toBigDecimal(n);
        return new Russian().amount(bd);
    }
}