/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lop.ws;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Anh
 */
@ServerEndpoint("/chat/chatEP")
public class Chat {

    private static Set<Session> wsSessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(String message) throws IOException, EncodeException {
        for (Session wsSession : wsSessions) {
            wsSession.getBasicRemote().sendObject(message);
        }
    }

    @OnOpen
    public void onOpen(Session wsSession) {
        //System.out.println("onOpen");
        wsSessions.add(wsSession);
    }

    @OnClose
    public void onClose(Session wsSession) {
        //System.out.println("onClose");
        wsSessions.remove(wsSession);
    }
}
