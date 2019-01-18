package cn.situation.util;

import cn.situation.model.Plugin;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.*;

/**
 * @author lenzhao
 * @date 2019/1/17 11:22
 * @description TODO
 */
public class XMLParser {

    public static List<Plugin> getPluginList() throws DocumentException {
        List<Plugin> list = new ArrayList<>();

        SAXReader saxReader =new SAXReader();
        URL url = ClassLoader.getSystemResource("plugins.xml");
        Document document = saxReader.read(url);
        Element root = document.getRootElement();
        List<?> plugins = root.elements("plugin");
        for(Object pluginObj : plugins) {
            Element pluginEle = (Element)pluginObj;
            Plugin plugin = new Plugin();
            plugin.setName(pluginEle.elementText("name"));
            plugin.setJar(pluginEle.elementText("jar"));
            plugin.setClassName(pluginEle.elementText("class"));
            Element propEle = pluginEle.element("properties");
            if (null != propEle) {
                Map<String, String> props = new HashMap<>();
                Iterator iters = propEle.elementIterator();
                while (iters.hasNext()) {
                    Element itemEle = (Element) iters.next();
                    String name = itemEle.attributeValue("name");
                    String value = itemEle.getTextTrim();
                    props.put(name, value);
                }
                plugin.setConfigs(props);
            }
            list.add(plugin);
        }
        return list;
    }
}
