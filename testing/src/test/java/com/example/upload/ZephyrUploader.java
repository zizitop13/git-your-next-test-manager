package com.example.upload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

public class ZephyrUploader {

    /**
     * https://support.atlassian.com/atlassian-account/docs/manage-api-tokens-for-your-atlassian-account/
     */
    static String token = "ATATT3xFfGF0LoSacKHO07QhZSGgGHyOeQE6iAQI_WxNhFre6wJrnsaf3tt50x55BI6PcDkSAaRvNEUF_yLhiVDLZpXnweRBG7kRs" +
            "_zKFG_jvlvukrtyjtuQ5MAu_KrTx4Zz2QkWdCgE_mTkB69aL0OtMnk3foKeW7FqdXS1uwdR5wKTy7Rp0IM=24B4735D";


    public static void main(String[] args) throws IOException {
        // Create the request model
        IssueBulk requestModel = createIssues();

        // Serialize the request model to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        String bodyData = objectMapper.writeValueAsString(requestModel);
        String apiUrl = "https://my-spot.atlassian.net/rest/api/3/issue/bulk";
        String auth = "zinmv@outlook.com:" + token;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Authorization", "Basic " + encodedAuth)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(bodyData))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int responseCode = response.statusCode();
            String responseMessage = response.body();

            System.out.println("Response: " + responseCode + " " + responseMessage);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * https://support.smartbear.com/zephyr-squad-cloud/docs/api/bdd.html
     * https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-issues/#api-rest-api-3-issue-post
     *
     * @return
     */
    private static IssueBulk createIssues() {
        return IssueBulk.builder()
                .issueUpdates(List.of(
                        Issue.builder()
                                .fields(Issue.Fields.builder()
                                        .summary("Feature2")
                                        .project(Issue.Project.builder()
                                                .id("10000")
                                                .build())
                                        .issuetype(Issue.IssueType.builder()
                                                .id("10005")
                                                .build())
                                        .labels(List.of("BDD_Scenario"))
                                        .build())
                                .build()
                ))
                .build();
    }
}
