package cn.situation;

import cn.situation.model.Plugin;
import cn.situation.service.PluginService;
import cn.situation.support.service.PluginManager;
import cn.situation.util.XMLParser;

import java.util.List;

/**
 * @author lenzhao
 * @date 2019/1/17 11:34
 * @description TODO
 */
public class Main {

    public static void main(String[] args) {
        try {
            List<Plugin> pluginList = XMLParser.getPluginList();
            PluginManager pluginManager = new PluginManager(pluginList);
            for(Plugin plugin : pluginList) {
                PluginService pluginService = pluginManager.getInstance(plugin.getClassName());
                System.out.println("开始执行[" + plugin.getName() + "]插件...");
                pluginService.service(plugin.getConfigs());
                System.out.println("[" + plugin.getName() + "]插件执行完成");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
