package co.com.mercado.libre.business;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    private Message message;

    @Test
    public void getMessagesNested(){
        String out="este es un mensaje secreto ";
        List<String> s1= Arrays.asList("este","","", "mensaje","");
        List<String> s2= Arrays.asList("","es" , "", "", "secreto");
        List<String> s3= Arrays.asList("este", "" ,"un", "","");

        assertEquals(out,message.getMessage(s1,s2,s3));

    }
}
