package com.telegrambot.project.bankruptcy.service.chose_manager;

import com.telegrambot.project.bankruptcy.service.Actions;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

import static com.telegrambot.project.bankruptcy.Application.replyKeyboardMarkupBuilder;

public class ChooseManagerAction4 implements Actions {

    public final String action;
    public ChooseManagerAction4(String action) {
        this.action = action;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Есть ли у вас недвижимое имущество?";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    @Override
    public BotApiMethod callback(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = EmojiParser.parseToUnicode("Принято :white_check_mark:");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(initReplyMarkupB());
        return sendMessage;
    }


    public static ReplyKeyboardMarkup initReplyMarkupB() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();
        keyboardMarkup.setIsPersistent(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);

        keyboardRow.add(new KeyboardButton("Перейти к следующему вопросу 5/6"));
        keyboardRow1.add(new KeyboardButton("Вернуться назад"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
