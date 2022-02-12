package leetcode.trulyMostPopular;

import java.util.*;

/**
 * @author itrover
 * 面试题 17.07. 婴儿名字 https://leetcode-cn.com/problems/baby-names-lcci/
 * 并查集
 */
class Solution {

    class Union {
        Map<String, Integer> nameToIndex;
        String[]  indexToName;
        int[] parent;

        public Union(int n, Set<String> set) {
            parent = new int[n];
            nameToIndex = new HashMap<>();
            indexToName = new String[n];
            int i = 0;
            // name与i映射
            for (String name : set) {
                nameToIndex.put(name, i);
                indexToName[i++] = name;
            }
            i = 0;
            while (i < n) {
                parent[i] = i;
                i++;
            }
        }

        /**
         * 合并名字
         * @param a
         * @param b
         * @return
         */
        public void unionSet(String a, String b) {
            // 寻找a，b的最简名字
            String pa = find(a);
            String pb = find(b);
            if (pa.compareTo(pb) > 0) {
                // pb更简单
                int index = nameToIndex.get(pa);
                parent[index] = nameToIndex.get(pb);
            } else {
                int index = nameToIndex.get(pb);
                parent[index] = nameToIndex.get(pa);
            }
        }

        /**
         * 寻找最简的名字
         * @param name
         * @return
         */
        public String find(String name) {
            if (!nameToIndex.containsKey(name)) {
                return name;
            }
            int i = nameToIndex.get(name);
            return i == parent[i] ? name : find(indexToName[parent[i]]);
        }


    }

    class Person {
        String name;
        int count;
    }

    Person StrToP(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) != '(') {
            i++;
        }
        Person p = new Person();
        p.name = str.substring(0, i);
        p.count = Integer.parseInt(str.substring(i + 1, str.length() - 1));
        return p;
    }

    String PToStr(Person p) {
        StringBuilder sb = new StringBuilder();
        sb.append(p.name);
        sb.append('(');
        sb.append(p.count);
        sb.append(')');
        return sb.toString();
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        HashMap<String, Person> map = new HashMap<>();
        HashSet<String> synonymSet = new HashSet<>();
        String[][] t = new String[synonyms.length][2];
        // 读取别名
        int i = 0;
        for (String synonym : synonyms) {
            String[] split = synonym.split(",");
            String a = split[0].substring(1);
            String b = split[1].substring(0, split[1].length() - 1);
            synonymSet.add(a);
            synonymSet.add(b);
            t[i][0] = a;
            t[i][1] = b;
            i++;
        }
        Union union = new Union(synonymSet.size(), synonymSet);
        for (i = 0; i < t.length; i++) {
            union.unionSet(t[i][0], t[i][1]);
        }
        for (String name : names) {
            Person p = StrToP(name);
            p.name = union.find(p.name);
            if (!map.containsKey(p.name)) {
                map.put(p.name, p);
            } else {
                Person person = map.get(p.name);
                person.count += p.count;
                map.put(p.name, person);
            }
        }

        String[] res = new String[map.size()];
        i = 0;
        for (Map.Entry<String, Person> person : map.entrySet()) {
            res[i] = PToStr(person.getValue());
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] names = {"Fcclu(70)","Ommjh(63)","Dnsay(60)","Qbmk(45)","Unsb(26)","Gauuk(75)","Wzyyim(34)","Bnea(55)","Kri(71)","Qnaakk(76)","Gnplfi(68)","Hfp(97)","Qoi(70)","Ijveol(46)","Iidh(64)","Qiy(26)","Mcnef(59)","Hvueqc(91)","Obcbxb(54)","Dhe(79)","Jfq(26)","Uwjsu(41)","Wfmspz(39)","Ebov(96)","Ofl(72)","Uvkdpn(71)","Avcp(41)","Msyr(9)","Pgfpma(95)","Vbp(89)","Koaak(53)","Qyqifg(85)","Dwayf(97)","Oltadg(95)","Mwwvj(70)","Uxf(74)","Qvjp(6)","Grqrg(81)","Naf(3)","Xjjol(62)","Ibink(32)","Qxabri(41)","Ucqh(51)","Mtz(72)","Aeax(82)","Kxutz(5)","Qweye(15)","Ard(82)","Chycnm(4)","Hcvcgc(97)","Knpuq(61)","Yeekgc(11)","Ntfr(70)","Lucf(62)","Uhsg(23)","Csh(39)","Txixz(87)","Kgabb(80)","Weusps(79)","Nuq(61)","Drzsnw(87)","Xxmsn(98)","Onnev(77)","Owh(64)","Fpaf(46)","Hvia(6)","Kufa(95)","Chhmx(66)","Avmzs(39)","Okwuq(96)","Hrschk(30)","Ffwni(67)","Wpagta(25)","Npilye(14)","Axwtno(57)","Qxkjt(31)","Dwifi(51)","Kasgmw(95)","Vgxj(11)","Nsgbth(26)","Nzaz(51)","Owk(87)","Yjc(94)","Hljt(21)","Jvqg(47)","Alrksy(69)","Tlv(95)","Acohsf(86)","Qejo(60)","Gbclj(20)","Nekuam(17)","Meutux(64)","Tuvzkd(85)","Fvkhz(98)","Rngl(12)","Gbkq(77)","Uzgx(65)","Ghc(15)","Qsc(48)","Siv(47)"};
        String[] sy = {"(Gnplfi,Qxabri)","(Uzgx,Siv)","(Bnea,Lucf)","(Qnaakk,Msyr)","(Grqrg,Gbclj)","(Uhsg,Qejo)","(Csh,Wpagta)","(Xjjol,Lucf)","(Qoi,Obcbxb)","(Npilye,Vgxj)","(Aeax,Ghc)","(Txixz,Ffwni)","(Qweye,Qsc)","(Kri,Tuvzkd)","(Ommjh,Vbp)","(Pgfpma,Xxmsn)","(Uhsg,Csh)","(Qvjp,Kxutz)","(Qxkjt,Tlv)","(Wfmspz,Owk)","(Dwayf,Chycnm)","(Iidh,Qvjp)","(Dnsay,Rngl)","(Qweye,Tlv)","(Wzyyim,Kxutz)","(Hvueqc,Qejo)","(Tlv,Ghc)","(Hvia,Fvkhz)","(Msyr,Owk)","(Hrschk,Hljt)","(Owh,Gbclj)","(Dwifi,Uzgx)","(Iidh,Fpaf)","(Iidh,Meutux)","(Txixz,Ghc)","(Gbclj,Qsc)","(Kgabb,Tuvzkd)","(Uwjsu,Grqrg)","(Vbp,Dwayf)","(Xxmsn,Chhmx)","(Uxf,Uzgx)"};
        String[] strings = solution.trulyMostPopular(names, sy);
        System.out.println(Arrays.toString(strings));
    }
}
