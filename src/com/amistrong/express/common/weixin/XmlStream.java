package com.amistrong.express.common.weixin;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import  com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.core.util.QuickWriter;

public final class XmlStream {

	private static XStream xstream = new XStream(new XppDriver(){
        public HierarchicalStreamWriter createWriter(Writer out){

            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记 
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }
 
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}