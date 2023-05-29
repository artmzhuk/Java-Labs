import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.Scanner;

public class Publisher {
    public static String getJson(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = reader.nextInt();
        System.out.println("Enter b: ");
        int b = reader.nextInt();
        System.out.println("Enter c: ");
        int c = reader.nextInt();
        reader.close();

        JSONObject jo = new JSONObject();
        jo.put("a", a);
        jo.put("b", b);
        jo.put("c", c);
        return jo.toString();
    }

    public static void main(String[] args) throws MqttException {
        String messageString;

        System.out.println("== START PUBLISHER ==");


        MqttClient client = new MqttClient("tcp://test.mosquitto.org:1883", MqttClient.generateClientId());
        client.connect();
        MqttMessage message = new MqttMessage();
        if (args.length == 2) {
            messageString = args[1];
        } else {
            messageString = getJson();
        }
        message.setPayload(messageString.getBytes());
        client.publish("IU69", message);

        System.out.println("\tMessage '" + messageString + "' to IU69");

        client.disconnect();

        System.out.println("== END PUBLISHER ==");

    }
}

