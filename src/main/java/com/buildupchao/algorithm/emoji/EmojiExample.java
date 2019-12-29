package com.buildupchao.algorithm.emoji;

import com.vdurmont.emoji.EmojiParser;

/**
 * @author buildupchao
 * @date 2019/12/29 05:05
 * @since JDK 1.8
 */
public class EmojiExample {

    public static void main(String[] args) throws Exception {
        emoji();
    }

    public static void emoji() throws Exception{
        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);
        result = EmojiParser.parseToAliases(str);
        System.out.println(result);


        String emojiString = "\uD83D\uDE02";
        System.out.println(EmojiParser.extractEmojis(emojiString));

    }
}
