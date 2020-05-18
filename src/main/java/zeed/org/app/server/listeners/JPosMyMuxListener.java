package zeed.org.app.server.listeners;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

import java.io.IOException;

public class JPosMyMuxListener implements ISORequestListener {
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        try {
            isoMsg.setMTI("0810");
            isoMsg.set(77, "056321");
            isoSource.send(isoMsg);
        } catch (ISOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
