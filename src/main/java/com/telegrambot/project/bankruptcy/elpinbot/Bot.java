package com.telegrambot.project.bankruptcy.elpinbot;

import com.telegrambot.project.bankruptcy.service.Actions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.telegrambot.project.bankruptcy.Application.defaultButton;
import static com.telegrambot.project.bankruptcy.Application.replyKeyboardMarkupBuilder;

@Slf4j
@Component
public class Bot extends TelegramLongPollingBot {
    private static final String BOT_NAME = "Elpin";
    private final Map<String, String> bindingBy = new ConcurrentHashMap<>();
    private final Map<String, Actions> actions;


    public Bot(@Value("${bot.token}") String botToken, Map<String, Actions> actions) {
        super(botToken);
        this.actions = actions;
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            String key = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            log.info("Пришел запрос {} от пользователя бота -> {}", update.getMessage().getText(), update.getMessage().getChat().getFirstName());

            if (actions.containsKey(key)) {
                var msg = actions.get(key).handle(update);
                bindingBy.put(chatId, key);
                sendMessage(msg);
            } else if (bindingBy.containsKey(chatId)) {
                var msg = actions.get(bindingBy.get(chatId)).callback(update);
                bindingBy.remove(chatId);
                sendMessage(msg);
            } else {
                sendMessage(defaultAnswer(update));
            }
        }
    }


    public void sendMessage(BotApiMethod msg) {
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            log.info("Ошибка отправки сообщения -> {}", e.getMessage());
            e.printStackTrace();
        }
    }



    public BotApiMethod defaultAnswer(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String text = "Ваш запрос будет обработан. Чтобы сделать новый запрос, вернитесь к началу";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(defaultButton());
        return sendMessage;
    }
}

