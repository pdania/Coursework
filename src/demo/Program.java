/*
 * Copyright (c) 2013, Pullenti. All rights reserved. Non-Commercial Freeware.
 * This class is generated using the converter UniSharping (www.unisharping.ru) from Pullenti C#.NET project (www.pullenti.ru).
 * See www.pullenti.ru/downloadpage.aspx.
 */

package demo;

import com.pullenti.morph.MorphLang;

public class Program {

    public static void main(String[] args) throws Exception, java.io.IOException {
        com.pullenti.unisharp.Stopwatch sw = com.pullenti.unisharp.Utils.startNewStopwatch();
        // инициализация - необходимо проводить один раз до обработки текстов
        System.out.print("Initializing ... ");
        // инициализируются движок и все имеющиеся анализаторы
        com.pullenti.ner.Sdk.initialize(com.pullenti.morph.MorphLang.ooBitor(MorphLang.UA, MorphLang.UNKNOWN));
        sw.stop();
        System.out.println("OK (by " + ((int)sw.getElapsedMilliseconds()) + " ms), version " + com.pullenti.ner.ProcessorService.getVersion());
        // анализируемый текст
        //String txt = "Единственным конкурентом «Трансмаша» на этом сомнительном тендере было ООО «Плассер Алека Рейл Сервис», основным владельцем которого является австрийская компания «СТЦ-Холдинг ГМБХ». До конца 2011 г. эта же фирма была совладельцем «Трансмаша» вместе с «Тако» Краснова. Зато совладельцем «Плассера», также до конца 2011 г., был тот самый Карл Контрус, который имеет четверть акций «Трансмаша». ";
        String txt = "Периметр рівнобедренного трикутника дорівнює 28 см, а бічна сторона - 10 см. Знайдіть основу трикутника.";
        System.out.println("Text: " + txt);
        // запускаем обработку на пустом процессоре (без анализаторов NER)
        com.pullenti.ner.AnalysisResult are = com.pullenti.ner.ProcessorService.getEmptyProcessor().process(new com.pullenti.ner.SourceOfAnalysis(txt), null, null);
        System.out.print("Noun groups: ");
        // перебираем токены
        for (com.pullenti.ner.Token t = are.firstToken; t != null; t = t.getNext()) {
            // выделяем именную группу с текущего токена
            com.pullenti.ner.core.NounPhraseToken npt = com.pullenti.ner.core.NounPhraseHelper.tryParse(t, com.pullenti.ner.core.NounPhraseParseAttr.NO, 0);
            // не получилось
            if (npt == null) 
                continue;
            // получилось, выводим в нормализованном виде
            System.out.print("[" + npt.getSourceText() + "=>" + npt.getNormalCaseText(null, true, com.pullenti.morph.MorphGender.UNDEFINED, false) + "] ");
            // указатель на последний токен именной группы
            t = npt.getEndToken();
        }
        try (com.pullenti.ner.Processor proc = com.pullenti.ner.ProcessorService.createProcessor()) {
            // анализируем текст
            com.pullenti.ner.AnalysisResult ar = proc.process(new com.pullenti.ner.SourceOfAnalysis(txt), null, null);
            // результирующие сущности
            System.out.println("\r\n==========================================\r\nEntities: ");
            for (com.pullenti.ner.Referent e : ar.getEntities()) {
                System.out.println(e.getTypeName() + ": " + e.toString());
                for (com.pullenti.ner.Slot s : e.getSlots()) {
                    System.out.println("   " + s.getTypeName() + ": " + s.getValue());
                }
            }
            // пример выделения именных групп
            System.out.println("\r\n==========================================\r\nNoun groups: ");
            for (com.pullenti.ner.Token t = ar.firstToken; t != null; t = t.getNext()) {
                // токены с сущностями игнорируем
                if (t.getReferent() != null) 
                    continue;
                // пробуем создать именную группу
                com.pullenti.ner.core.NounPhraseToken npt = com.pullenti.ner.core.NounPhraseHelper.tryParse(t, com.pullenti.ner.core.NounPhraseParseAttr.ADJECTIVECANBELAST, 0);
                // не получилось
                if (npt == null) 
                    continue;
                System.out.println(npt);
                // указатель перемещаем на последний токен группы
                t = npt.getEndToken();
            }
        }
        try (com.pullenti.ner.Processor proc = com.pullenti.ner.ProcessorService.createSpecificProcessor(com.pullenti.ner.keyword.KeywordAnalyzer.ANALYZER_NAME)) {
            com.pullenti.ner.AnalysisResult ar = proc.process(new com.pullenti.ner.SourceOfAnalysis(txt), null, null);
            System.out.println("\r\n==========================================\r\nKeywords1: ");
            for (com.pullenti.ner.Referent e : ar.getEntities()) {
                if (e instanceof com.pullenti.ner.keyword.KeywordReferent) 
                    System.out.println(e);
            }
            System.out.println("\r\n==========================================\r\nKeywords2: ");
            for (com.pullenti.ner.Token t = ar.firstToken; t != null; t = t.getNext()) {
                if (t instanceof com.pullenti.ner.ReferentToken) {
                    com.pullenti.ner.keyword.KeywordReferent kw = (com.pullenti.ner.keyword.KeywordReferent)com.pullenti.unisharp.Utils.cast(t.getReferent(), com.pullenti.ner.keyword.KeywordReferent.class);
                    if (kw == null) 
                        continue;
                    String kwstr = com.pullenti.ner.core.MiscHelper.getTextValueOfMetaToken((com.pullenti.ner.ReferentToken)com.pullenti.unisharp.Utils.cast(t, com.pullenti.ner.ReferentToken.class), com.pullenti.ner.core.GetTextAttr.of((com.pullenti.ner.core.GetTextAttr.FIRSTNOUNGROUPTONOMINATIVESINGLE.value()) | (com.pullenti.ner.core.GetTextAttr.KEEPREGISTER.value())));
                    System.out.println(kwstr + " = " + kw);
                }
            }
        }
        System.out.println("Over!");
    }
    public Program() {
    }
}
