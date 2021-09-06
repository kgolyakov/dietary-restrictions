package telegrambotUI;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import parsing.ParserManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.*;

public class TelegramBot extends TelegramLongPollingBot {
    private static final String botUserName = "JavaSchoolTestBot";
    private static final String token = "1993202006:AAFrRNzZwWHn7HeSF8Pp-4DdBr9MfucZFss";
    private ParserManager parserManager = new ParserManager();
    private List<UserIngredients> users = new ArrayList<UserIngredients>();
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasPhoto()) {
            String chatId = update.getMessage().getChatId().toString();
            users.add(new UserIngredients(chatId));

            java.io.File file = downloadPhotoByFilePath(getFilePath(getPhoto(update)));

            BufferedImage img = ImageIO.read(file);
            execute(new SendMessage(chatId, "Analyzing image..."));
            Map<String, List<String>> strings = parserManager.analyseImage(this, chatId, img);

        }
        if(update.hasCallbackQuery()){
            execute(correctIngredient(update.getCallbackQuery().getData().toString(), update.getCallbackQuery().getMessage().getChatId().toString()));

        }
        if (update.hasMessage() && update.getMessage().hasText()){

            String text = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            List<String> textList = List.of(text.split("_"));

            if (textList.size() == 2){
                for (UserIngredients user : users){
                    if (user.getChatId().equals(chatId)){

                        user.fixIngredient(textList.get(1));
                        execute(sendInlineKeyBoardMessage(chatId,user.getEntities()));
                    }
                }

            }
        }
    }

    public PhotoSize getPhoto(Update update) {
        // Check that the update contains a message and the message has a photo
        if (update.hasMessage() && update.getMessage().hasPhoto()) {
            // When receiving a photo, you usually get different sizes of it
            List<PhotoSize> photos = update.getMessage().getPhoto();

            // We fetch the bigger photo
            return photos.stream()
                    .max(Comparator.comparing(PhotoSize::getFileSize)).orElse(null);
        }

        // Return null if not found
        return null;
    }

    public String getFilePath(PhotoSize photo) {
        Objects.requireNonNull(photo);
{ // If not, let find it
            // We create a GetFile method and set the file_id from the photo
            GetFile getFileMethod = new GetFile();
            getFileMethod.setFileId(photo.getFileId());
            try {
                // We execute the method using AbsSender::execute method.
                File file = execute(getFileMethod);
                // We now have the file_path
                return file.getFilePath();
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        return null; // Just in case
    }
    public java.io.File downloadPhotoByFilePath(String filePath) {
        try {
            // Download the file calling AbsSender::downloadFile method
            return downloadFile(filePath);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public SendMessage sendInlineKeyBoardMessage(String chatId, List<String> ingredientsInfo) {
        for (UserIngredients user:users){
            if (user.getChatId().equals(chatId)){
                user.setEntities(ingredientsInfo);
            }
        }
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        for (String ingredient : ingredientsInfo) {
            InlineKeyboardButton temp = new InlineKeyboardButton();
            temp.setText(ingredient);
            temp.setCallbackData(ingredient);
            keyboardButtonsRow1.add(temp);
        }

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);

        inlineKeyboardMarkup.setKeyboard(rowList);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Проверьте состав вашего продукта");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    public SendMessage correctIngredient(String incorrectOne, String chatId){
        for (UserIngredients user:users){
            if (user.getChatId().equals(chatId)){
                user.setIncorrectProduct(incorrectOne);
            }
        }

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Введите правильное название продукта в формате correct_названиеПродукта");
        sendMessage.setChatId(chatId);
        return sendMessage;
    }
}
