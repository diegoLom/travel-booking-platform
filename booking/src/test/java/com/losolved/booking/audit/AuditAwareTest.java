package com.losolved.booking.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.AuditorAware;

import com.losolved.booking.audit.AuditAwareImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class AuditAwareTest {
	
	private AuditorAware<String> auditAwareImpl;
	
	@BeforeAll
	private void setup() {
		auditAwareImpl = new AuditAwareImpl();
	}
	
	@Test
	public void testCurrentAuditor() {
		assertEquals(auditAwareImpl.getCurrentAuditor(), Optional.of("LOSOLVED"));
	}
}
