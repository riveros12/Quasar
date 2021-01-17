package co.com.mercado.libre.business;


import java.util.List;


/**
 * @author oscarriveros
 */
public class Message {


    /**
     * getMessagesNested
     * @param messages
     * @return
     */
    public static String getMessagesNested(String[] messages) {
        String messageNested = "";
        for (String chain : messages) {
            if (chain != null) {
                messageNested += chain + " ";
            }
        }
        return messageNested;
    }

    /**
     * getMessages
     * @param satellite_1
     * @param satellite_2
     * @param satellite_3
     * @return
     */
    public static String getMessage(List<String> satellite_1, List<String> satellite_2, List<String> satellite_3) {
        if (satellite_1.size() == satellite_2.size()  &&  satellite_2.size() == satellite_3.size()) {
            int higher = satellite_1.size();
            String[] message = new String[higher];
            for (int i = 0; i < higher; i++) {
                if (!satellite_1.get(i).isEmpty()) {
                    message[i] = satellite_1.get(i);
                } else if (!satellite_2.get(i).isEmpty()) {
                    message[i] = satellite_2.get(i);
                } else if (!satellite_3.get(i).isEmpty()) {
                    message[i] = satellite_3.get(i);
                }
            }
            return getMessagesNested(message);
        } else {return null;}
    }
}
