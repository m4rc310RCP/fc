package br.com.m4rc310.fc.services;

import br.com.m4rc310.fc.audit.models.Audit;

public interface IAudit {
	Audit getAudit();
	void setAudit(Audit audit);
}
