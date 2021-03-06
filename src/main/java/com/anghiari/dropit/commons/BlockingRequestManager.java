package com.anghiari.dropit.commons;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: sunimal
 */
public class BlockingRequestManager {
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;
    private Socket clientSocket = null;

    //Send pkt to FileNode dest and wait for request. Returns dropit pkt.
    public DropItPacket sendMessageAndWaitForRequest(DropItPacket pkt, FileNode dest){
        Object returnObject=null;
        System.out.println(">>>>>>>>>>>BLOCKING HANDLER SENDING MSG<<<<<<<<");
        try {
            clientSocket = new Socket(dest.getIp(), dest.getPort_ring());
            outStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outStream.writeObject(pkt);
            inStream=new ObjectInputStream(clientSocket.getInputStream());
            returnObject= inStream.readObject();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            System.out.println(">>>>>BLOCKING HANDLER GOT REPLY<<<<<<");
            return (DropItPacket)returnObject;
        }

    }

}
