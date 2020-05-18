package zeed.org.app.server.listeners;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

import java.io.IOException;

public class JPosAutoResponderListener implements ISORequestListener {
    public boolean process(ISOSource isoSource, ISOMsg isoMsg) {
        try {
            if (isoMsg.hasField(2) && isoMsg.getString(2).startsWith("411111")) {
                return false;
            }
            isoMsg.setMTI("0810");
            isoMsg.set(39, "00");
            isoSource.send(isoMsg);
        } catch (ISOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
