package com.risepu.ftk.web.b.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.risepu.ftk.server.domain.DocumentData;
import com.risepu.ftk.server.domain.ProofDocument;
import com.risepu.ftk.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.risepu.ftk.server.domain.Domain;
import com.risepu.ftk.server.domain.Template;
import com.risepu.ftk.web.api.Response;

/**
 * @author L-heng
 */
@Controller
@RequestMapping("/api/template")
public class CompanyTemplateController implements CompanyTemplateApi {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private DomainService domainService;

    @Autowired
    private ProofDocumentService proofDocumentService;

    @Autowired
    private DocumentDateService documentDateService;

    @Override
    public ResponseEntity<Response<Template>> getTemplate(Long templateId) {
        Template template = templateService.getTemplate(templateId);
        return ResponseEntity.ok(Response.succeed(template));
    }

    @Override
    public ResponseEntity<Response<List<Template>>> getTemplates() {
        List<Template> templates = templateService.getTemplates();
        return ResponseEntity.ok(Response.succeed(templates));
    }

    @Override
    public ResponseEntity<Response<List<Domain>>> getAllTemplateData(Long templateId) {
        List<Domain> domains = domainService.selectByTemplate(templateId);
        return ResponseEntity.ok(Response.succeed(domains));
    }

    @Override
    public ResponseEntity<Response<List>> getAllDocument(String organization) {
        List<ProofDocument> proofDocuments = proofDocumentService.getByOrganization(organization);
        List list = new ArrayList();
        for (int i = 0; i < proofDocuments.size(); i++) {
            Map map = new HashMap();
            ProofDocument proofDocument = proofDocuments.get(i);
            List<DocumentData> documentDataList = documentDateService.getByDocumentId(proofDocument.getId());
            map.put("区块链哈希", proofDocument.getChainHash());
            map.put("单号", proofDocument.getId());
            for (int j = 0; j < documentDataList.size(); j++) {
                DocumentData documentData = documentDataList.get(j);
                Domain domain = domainService.selectById(documentData.getId().getDomainId());
                map.put(domain.getLabel(), documentData.getValue());
            }
            list.add(map);
        }
        return ResponseEntity.ok(Response.succeed(list));
    }
}