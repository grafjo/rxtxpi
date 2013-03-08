package de.synyx.rxtxpi;

import gnu.io.CommPortIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;

/**
 * @author Johannes Graf - graf@synyx.de
 */
public class SerialPortUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SerialPortUtils.class);

    public static void showAvailablePorts() {

        LOG.info("Looking for serial ports");

        @SuppressWarnings("unchecked")
        Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();

        if (ports == null || (ports != null && !ports.hasMoreElements())) {
            LOG.error("No serial ports found!");
        } else {

            while (ports.hasMoreElements()) {

                CommPortIdentifier port = ports.nextElement();

                LOG.info("Found port: " + port.getName());
            }
        }
    }
}
