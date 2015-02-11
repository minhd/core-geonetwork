package org.fao.geonet.wro4j;

import ro.isdc.wro.http.WroFilter;

import java.net.SocketException;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jesse on 2/1/2015.
 */
public class GeonetWro4jFilter extends WroFilter {
    @Override
    protected void onException(Exception e, HttpServletResponse response, FilterChain chain) {
        if (e.getCause() instanceof SocketException) {
            // ignore this because it means that a client closed the socket while data was being written to it.
        } else {
            super.onException(e, response, chain);
        }
    }
}
