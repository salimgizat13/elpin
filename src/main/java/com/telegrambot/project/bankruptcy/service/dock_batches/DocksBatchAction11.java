package com.telegrambot.project.bankruptcy.service.dock_batches;

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

public class DocksBatchAction11 implements Actions {

    public final String action;
    public DocksBatchAction11(String actions) {
        this.action = actions;
    }

    @Override
    public BotApiMethod handle(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Информация из официального сайта Федеральной налоговой службы nalog.ru подтверждающая сведения о доходах Должника";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(initReplyMarkupA());
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

    public static ReplyKeyboardMarkup initReplyMarkupA() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();
        keyboardMarkup.setIsPersistent(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);

        keyboardRow.add(new KeyboardButton("Нет такого документа (перейти к следующему 12/16)"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup initReplyMarkupB() {
        ReplyKeyboardMarkup keyboardMarkup = replyKeyboardMarkupBuilder();
        keyboardMarkup.setIsPersistent(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        keyboardRows.add(keyboardRow1);

        keyboardRow.add(new KeyboardButton("Прикрепить следующий документ 12/16"));
        keyboardRow1.add(new KeyboardButton("Вернуться назад"));

        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }
}
