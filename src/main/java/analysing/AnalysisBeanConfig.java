package analysing;

import analysing.services.Analyser;
import analysing.services.AnalyserImpl;
import analysing.services.PersonalizedAnalyser;
import analysing.services.PersonalizedAnalyserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration
public class AnalysisBeanConfig {
/*
    @Bean(name = "analyser")
    public Analyser analyser() {
        return new AnalyserImpl();
    }

    @Bean(name = "personalizedAnalyzer")
    public PersonalizedAnalyser personalizedAnalyser() { return new PersonalizedAnalyserImpl(); }

    @Bean(name = "analysisManager")
    public AnalysisManager analysisManager() {
        return new AnalysisManager();
    }*/
}
