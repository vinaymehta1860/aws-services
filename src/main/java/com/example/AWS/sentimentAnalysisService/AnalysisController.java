package com.example.AWS.sentimentAnalysisService;


import com.example.AWS.sentimentAnalysisService.DTO.Analysis;
import com.example.AWS.sentimentAnalysisService.RequestObjects.AnalyseText;
import com.example.AWS.sentimentAnalysisService.RequestObjects.AnalyseTexts;
import com.example.AWS.sentimentAnalysisService.services.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnalysisController {

    @Autowired
    AnalysisService analysisService;

    @RequestMapping(method = RequestMethod.POST, value = "/analyze/text")
    public Analysis analyzeText(@RequestBody AnalyseText analyseText) {
        if (analyseText.getText().length() == 0) {
            return null;
        }

        return analysisService.analyzeText(analyseText.getText());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/analyze/texts")
    public List<Analysis> analyzeTexts(@RequestBody AnalyseTexts analyseTexts) {
        if (analyseTexts.getTexts().size() == 0) {
            return null;
        }

        return analysisService.analyzeTexts(analyseTexts.getTexts());
    }
}
