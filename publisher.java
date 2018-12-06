import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublishSample implements MqttCallback {
	
	
	private  MqttClient sampleClient;
	public static void main(String[] args) {
		new MqttPublishSample();
		
	}

public MqttPublishSample() {

    String topic        = "test/testing";
    String content      = "24.1";
    int qos             = 1;
    String broker       = "";
    String clientId     = "";
    String password 	= "";
    MemoryPersistence persistence = new MemoryPersistence();

    try {
        sampleClient = new MqttClient(broker, clientId, persistence);
      
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setPassword(password.toCharArray());
        System.out.println("Connecting to broker: "+broker);
        sampleClient.connect(connOpts);
        sampleClient.setCallback(this);
        sampleClient.subscribe(topic);
        System.out.println("Connected");
        //System.out.println("Publishing message: "+content + " to topic: " + topic );
        //MqttMessage message = new MqttMessage(content.getBytes());
        //message.setQos(qos);
        //sampleClient.publish(topic, message);
        //System.out.println("Message published");
        //sampleClient.disconnect();
        //System.out.println("Disconnected");
        
    } catch(MqttException me) {
        System.out.println("reason "+me.getReasonCode());
        System.out.println("msg "+me.getMessage());
        System.out.println("loc "+me.getLocalizedMessage());
        System.out.println("cause "+me.getCause());
        System.out.println("excep "+me);
        me.printStackTrace();
    }
}

@Override
public void connectionLost(Throwable arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void deliveryComplete(IMqttDeliveryToken arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void messageArrived(String topic, MqttMessage message) throws Exception {
	System.out.println("Message recieved:" + message);
	//System.out.println("Disconnected");
	//sampleClient.disconnect();
	
}
}
