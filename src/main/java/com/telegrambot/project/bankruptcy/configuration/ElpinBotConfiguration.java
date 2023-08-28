package com.telegrambot.project.bankruptcy.configuration;

import com.telegrambot.project.bankruptcy.elpinbot.Bot;
import com.telegrambot.project.bankruptcy.service.*;
import com.telegrambot.project.bankruptcy.service.chose_manager.*;
import com.telegrambot.project.bankruptcy.service.dock_batches.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ElpinBotConfiguration {

    @Bean
    public TelegramBotsApi telegramBotsApi(Bot bot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
        return telegramBotsApi;
    }

    @Bean
    public Map<String, Actions> actionsMap() {
        HashMap<String, Actions> stringActionsHashMap = new HashMap<>();
        stringActionsHashMap.put("/start", new StartAction("/start"));
        stringActionsHashMap.put("Вернуться назад", new StartAction("Вернуться назад"));
        stringActionsHashMap.put("О нас", new InfoAction("О нас"));
        stringActionsHashMap.put("Задать вопрос юристу", new QuestionToLawyerAction("Задать вопрос юристу"));
        stringActionsHashMap.put("Направить пакет документов", new DocksBatchAction("Направить пакет документов"));
        stringActionsHashMap.put("Выбрать арбитражного управляющего", new ChooseManagerAction("Выбрать арбитражного управляющего"));
        stringActionsHashMap.put("Заполнить", new ChooseManagerAction1("Выбрать арбитражного управляющего"));
        stringActionsHashMap.put("Перейти к следующему вопросу 2/6", new ChooseManagerAction2("Выбрать арбитражного управляющего"));
        stringActionsHashMap.put("Перейти к следующему вопросу 3/6", new ChooseManagerAction3("Выбрать арбитражного управляющего"));
        stringActionsHashMap.put("Перейти к следующему вопросу 4/6", new ChooseManagerAction4("Выбрать арбитражного управляющего"));
        stringActionsHashMap.put("Перейти к следующему вопросу 5/6", new ChooseManagerAction5("Выбрать арбитражного управляющего"));
        stringActionsHashMap.put("Перейти к следующему вопросу 6/6", new ChooseManagerAction6("Выбрать арбитражного управляющего"));



        stringActionsHashMap.put("Готов", new DocksBatchAction1("Готов"));
        stringActionsHashMap.put("Да", new DocksBatchAction1("Да"));
        stringActionsHashMap.put("да", new DocksBatchAction1("да"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 2/16)", new DocksBatchAction2("Нет такого документа (перейти к следующему 2/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 2/16", new DocksBatchAction2("Прикрепить следующий документ 2/16"));
        stringActionsHashMap.put("Нет такого документа (перейти к следующему 3/16)", new DocksBatchAction3("Нет такого документа (перейти к следующему 3/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 3/16", new DocksBatchAction3("Прикрепить следующий документ 3/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 4/16)", new DocksBatchAction4("Нет такого документа (перейти к следующему 4/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 4/16", new DocksBatchAction4("Прикрепить следующий документ 4/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 5/16)", new DocksBatchAction5("Нет такого документа (перейти к следующему 5/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 5/16", new DocksBatchAction5("Прикрепить следующий документ 5/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 6/16)", new DocksBatchAction6("Нет такого документа (перейти к следующему 6/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 6/16", new DocksBatchAction6("Прикрепить следующий документ 6/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 7/16)", new DocksBatchAction7("Нет такого документа (перейти к следующему 7/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 7/16", new DocksBatchAction7("Прикрепить следующий документ 7/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 8/16)", new DocksBatchAction8("Нет такого документа (перейти к следующему 8/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 8/16", new DocksBatchAction8("Прикрепить следующий документ 8/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 9/16)", new DocksBatchAction9("Нет такого документа (перейти к следующему 9/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 9/16", new DocksBatchAction9("Прикрепить следующий документ 9/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 10/16)", new DocksBatchAction10("Нет такого документа (перейти к следующему 10/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 10/16", new DocksBatchAction10("Прикрепить следующий документ 10/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 11/16)", new DocksBatchAction11("Нет такого документа (перейти к следующему 11/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 11/16", new DocksBatchAction11("Прикрепить следующий документ 11/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 12/16)", new DocksBatchAction12("Нет такого документа (перейти к следующему 12/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 12/16", new DocksBatchAction12("Прикрепить следующий документ 12/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 13/16)", new DocksBatchAction13("Нет такого документа (перейти к следующему 13/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 13/16", new DocksBatchAction13("Прикрепить следующий документ 13/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 14/16)", new DocksBatchAction14("Нет такого документа (перейти к следующему 14/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 14/16", new DocksBatchAction14("Прикрепить следующий документ 14/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 15/16)", new DocksBatchAction15("Нет такого документа (перейти к следующему 15/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 15/16", new DocksBatchAction15("Прикрепить следующий документ 15/16"));

        stringActionsHashMap.put("Нет такого документа (перейти к следующему 16/16)", new DocksBatchAction16("Нет такого документа (перейти к следующему 16/16)"));
        stringActionsHashMap.put("Прикрепить следующий документ 16/16", new DocksBatchAction16("Прикрепить следующий документ 16/16"));
        return stringActionsHashMap;
    }
}
