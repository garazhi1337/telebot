package telebot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot{
	public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}

	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
	    if (message!=null && message.hasText()) {
	    	SendMessage sm = new SendMessage();
	    	sm.enableMarkdown(true);
	    	sm.setChatId(message.getChatId());
	    	sm.setReplyToMessageId(message.getMessageId());
	    	sm.setText(message.getText());
	    	try {
				execute(sm);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
	    }
	}

	public String getBotUsername() {
		return "testTestTestTelegramBot";
	}

	@Override
	public String getBotToken() {
		return "5552684835:AAGvyGUfQEtAln7xXA9J86kcVtoDEIoDuzQ";
	}
}
