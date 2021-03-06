package community.solace.spring.integration.leader;

import community.solace.spring.integration.leader.aspect.LeaderAwareAspect;
import community.solace.spring.integration.leader.leader.SolaceLeaderConfig;
import community.solace.spring.integration.leader.leader.SolaceLeaderInitiator;
import com.solacesystems.jcsmp.SpringJCSMPFactory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SolaceLeaderConfig.class)
public class SolaceLeaderAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SolaceLeaderInitiator solaceLeaderInitiator(SpringJCSMPFactory solaceFactory, SolaceLeaderConfig solaceLeaderConfig, ApplicationContext appContext) {
        return new SolaceLeaderInitiator(solaceFactory, solaceLeaderConfig, appContext);
    }

    @Bean
    @ConditionalOnMissingBean
    public LeaderAwareAspect leaderAwareAspect() {
        return new LeaderAwareAspect();
    }

}
