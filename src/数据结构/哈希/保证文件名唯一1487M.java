package 数据结构.哈希;

import Utils.ArrayUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-29 22:24
 * @Description
 */
public class 保证文件名唯一1487M {

    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new LinkedHashMap<>();
        String[] ans = new String[names.length];
        int idx=0;
        for(String name : names){
            if(!map.containsKey(name)){
                map.put(name,1);
            }else{
                String newName;
                int num = map.get(name);
                do{
                    newName = name + "(" + num++ + ")";
                }while(map.containsKey(newName));

                map.put(name,num);
                map.put(newName,1);
            }
        }

        for(String name : map.keySet()){
            ans[idx++] = name;
        }

        return ans;
    }


    public static void main(String[] args) {
        保证文件名唯一1487M main = new 保证文件名唯一1487M();

        /**
         *给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
         *
         * 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，
         * 系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件名唯一的 最小正整数 。
         *
         * 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
         */
        ArrayUtils.print(main.getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"}));//[pes, fifa, gta, pes(2019)]
        ArrayUtils.print(main.getFolderNames(new String[]{"gta","gta(1)","gta","avalon"}));//[gta, gta(1), gta(2), avalon]
        ArrayUtils.print(main.getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"}));//[onepiece, onepiece(1), onepiece(2), onepiece(3), onepiece(4)]
        ArrayUtils.print(main.getFolderNames(new String[]{"wano","wano","wano","wano"}));//[wano, wano(1), wano(2), wano(3)]
        ArrayUtils.print(main.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"}));//[kaido, kaido(1), kaido(2), kaido(1)(1)]
    }
}
