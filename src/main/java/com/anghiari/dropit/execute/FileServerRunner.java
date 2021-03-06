package com.anghiari.dropit.execute;

import com.anghiari.dropit.commons.Configurations;
import com.anghiari.dropit.commons.FileNode;
import com.anghiari.dropit.commons.KeyId;
import com.anghiari.dropit.fileserver.impl.FileServerNodeImpl;
import com.anghiari.dropit.operations.ReqServerForNodeOperation;

/**
 * @author: chinthaka
 * starts the file server
 */
public class FileServerRunner {

    public static void main(String[] args) {

        String ip = Configurations.ip;
//        int numberOfNodes = Integer.parseInt(args[0]);
//
        int[] intPorts = Configurations.myPorts;
        int[] extPorts = Configurations.myPorts;
        int[] keys = Configurations.myKeys;
        int numberOfNodes = Configurations.myServerCount;
        FileNode node;
        FileServerNodeImpl fileServer;

        for(int i = 0; i < numberOfNodes; i++){
            node = new FileNode(ip, extPorts[i], intPorts[i], new KeyId(keys[i]));
            fileServer = new FileServerNodeImpl();
            fileServer.bootServer(node, true);
//            try{
//                Thread.sleep(100);
//            }catch (InterruptedException ex){}
        }

//        PingOperation op=new PingOperation(new FileServerNodeImpl(),ip, 14501);
//        op.sendRequest();
//        
//        
        FileServerNodeImpl newFileNode = new FileServerNodeImpl();

        ReqServerForNodeOperation reqSerOp = new ReqServerForNodeOperation(newFileNode);
        //CHINTHAKA REQUEST SERveR Caller
    }
}
