package com.comcast.ucsi.validation.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.comcast.ucsi.validation.service.model.Asset;
import com.comcast.ucsi.validation.service.model.CreateIngest;
import com.comcast.ucsi.validation.service.model.CreateIngestErrorResponseWrapper;
import com.comcast.ucsi.validation.service.model.CreateIngestRequestWrapper;
import com.comcast.ucsi.validation.service.model.Distribution;
import com.comcast.ucsi.validation.service.model.Title;
import com.comcast.ucsi.validation.service.processor.ValidationServiceProcessor;
import com.comcast.ucsi.validation.service.rule.IErrorMessageLoader;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	private static Log logger = LogFactory.getLog(ApplicationTests.class);

	@Autowired
	ValidationServiceProcessor processor;

	@Autowired
	IErrorMessageLoader errorMessageLoader;

	@Test
	void testInvalidJson() {
		logger.info("unit testing testInvalidJson");
		InputStream in = new ByteArrayInputStream("not json string / stream".getBytes());
		String output = processor.process((in)).toString();
		assertTrue(output.contains("400 BAD_REQUEST"));
		assertTrue(output.contains("Invalid request"));

		System.out.println("errorMessageLoader: " + errorMessageLoader);
		System.out.println("ValidationServiceProcessor: " + processor);
	}

	@Test
	void testInvalidCreateIngestPayload() {
		logger.info("unit testing testInvalidCreateIngestPayload");
		InputStream in = new ByteArrayInputStream("{\"value\":\"foo\"}".getBytes());
		String output = processor.process((in)).toString();
		assertTrue(output.contains("400 BAD_REQUEST"));
		assertTrue(output.contains("Invalid request"));

	}

	@Test
	void testMissingSourceFileLocatorAndFileName() throws IOException {
		logger.info("unit testing Missing Source File Locator And FileName");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSourceFileLocatorAndFileName.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());

		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.FileLocator.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.FileLocator.message")));

	}

	@Test
	void testMissingSourceVideoCodec() throws IOException {
		logger.info("unit testing test Missing Source Audio Codec");
		InputStream in = new FileInputStream("src/test/resources/TestMissingVideoCodec.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.Codec.title")));
		assertTrue(body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.Codec.message")));

	}

	@Test
	void testMissingDuration() throws IOException {
		logger.info("unit testing Missing Duration");
		InputStream in = new FileInputStream("src/test/resources/TestMissingDuration.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.Duration.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.Duration.message")));

	}

	@Test
	void testMissingContainer() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestMissingContainer.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.Container.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.Container.message")));

	}

	@Test
	void testMissingScreenFormate() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestMissingScreenFormate.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.ScreenFormat.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.ScreenFormat.message")));

	}

	@Test
	void testMisingVideoQuality() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestMissingVideoQuality.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.VideoQuality.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.VideoQuality.message")));

	}

	@Test
	void testMissingVideoQualityResolution() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestMissingVideoQualityResolution.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.VideoQualityResolution.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.VideoQualityResolution.message")));

	}

	@Test
	void testMissingHDR() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestMissingHDR.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.Hdr.title")));
		assertTrue(body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.Hdr.message")));

	}

	@Test
	void testMissingHDRType() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestMissingHdrTypeWithHdrTrue.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.HdrType.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.HdrType.message")));

	}

	@Test
	void testMissingSourceSegmentInfo() throws IOException {
		logger.info("unit testing testInvalidHDRType");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSourceSegmentInfo.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.SegmentInfo.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.SegmentInfo.message")));

	}

	@Test
	void testMissingSourceEmbeded() throws IOException {
		logger.info("unit testing TestMissingSourceEmbeded");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSourceEmbeded.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.Embedded.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.Embedded.message")));

	}

	@Test
	void testMissingSoureAudioType() throws IOException {
		logger.info("unit testing TestMissingSoureAudioType");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSoureAudioType.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.AudioType.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.AudioType.message")));

	}

	@Test
	void testMissingClosedcaptionFormate() throws IOException {
		logger.info("unit testing TestMissingClosedaptionFormate");
		InputStream in = new FileInputStream("src/test/resources/TestMissingClosedaptionFormate.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.ClosedCaptionFormat.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.ClosedCaptionFormat.message")));

	}

	@Test
	void testEmptyIngestPartner() throws IOException {
		logger.info("unit testing TestEmptyIngestPartner");
		InputStream in = new FileInputStream("src/test/resources/TestEmptyIngestPartner.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("CreateIngest.Partner.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("CreateIngest.Partner.message")));

	}

	@Test
	void testMissingIngestMainfestId() throws IOException {
		logger.info("unit testing TestMissingIngestMainfestId");
		InputStream in = new FileInputStream("src/test/resources/TestMissingIngestMainfestId.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("CreateIngest.ManifestId.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("CreateIngest.ManifestId.message")));

	}

	@Test
	void testMissingIngestTitle() throws IOException {
		logger.info("unit testing TestMissingIngestMainfestId");
		InputStream in = new FileInputStream("src/test/resources/TestMissingIngestTitle.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("CreateIngest.Title.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("CreateIngest.Title.message")));

	}

	@Test
	void testMissingIngestMainfest() throws IOException {
		logger.info("unit testing TestMissingIngestMainfest");
		InputStream in = new FileInputStream("src/test/resources/TestMissingIngestMainfest.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("CreateIngest.Manifest.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("CreateIngest.Manifest.message")));

	}

	@Test
	void testMissingIngestDistribution() throws IOException {
		logger.info("unit testing TestMissingIngestMainfest");
		InputStream in = new FileInputStream("src/test/resources/TestMissingIngestDistribution.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("CreateIngest.Distribution.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("CreateIngest.Distribution.message")));

	}

	@Test
	void testMissingMainfestSource() throws IOException {
		logger.info("unit testing TestMissingMainfestSource");
		InputStream in = new FileInputStream("src/test/resources/TestMissingMainfestSource.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Manifest.Source.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Manifest.Source.message")));

	}

	@Test
	void testMissingSegmentInfoNumber() throws IOException {
		logger.info("unit testing MissingSegmentInfoNumber");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSegmentInfoNumber.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("SegmentInfo.Number.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("SegmentInfo.Number.message")));

	}

	@Test
	void testMissingSegmentInoStartOfEssence() throws IOException {
		logger.info("unit testing MissingSegmentInoStartOfEssence");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSegmentInoStartOfEssence.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("SegmentInfo.StartOfEssence.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("SegmentInfo.StartOfEssence.message")));

	}

	@Test
	void testMissingSegmentInfoStartOfMedia() throws IOException {
		logger.info("unit testing TestMissingSegmentInfoStartOfMedia");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSegmentInfoStartOfMedia.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("SegmentInfo.StartOfMedia.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("SegmentInfo.StartOfMedia.message")));

	}

	@Test
	void testMissingSegmentInoEndOfMedia() throws IOException {
		logger.info("unit testing TestMissingSegmentInoEndOfMedia");
		InputStream in = new FileInputStream("src/test/resources/TestMissingSegmentInoEndOfMedia.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("SegmentInfo.EndOfMedia.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("SegmentInfo.EndOfMedia.message")));

	}

	@Test
	void testMissingDistributionGUID() throws IOException {
		logger.info("unit testing TestMissingDistributionGUID");
		InputStream in = new FileInputStream("src/test/resources/TestMissingDistributionGUID.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Distribution.Guid.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Distribution.Guid.message")));

	}

	@Test
	void testMissingDistributionPackage() throws IOException {
		logger.info("unit testing TestMissingDistributionPackage");
		InputStream in = new FileInputStream("src/test/resources/TestMissingDistributionPackage.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Distribution.Package.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Distribution.Package.message")));

	}

	@Test
	void testMissingDistributionViedoQuality() throws IOException {
		logger.info("unit testing TestMissingDistributionPackage");
		InputStream in = new FileInputStream("src/test/resources/TestMissingDistributionViedoQuality.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Distribution.VideoQuality.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Distribution.VideoQuality.message")));

	}

	@Test
	void testMissingPackageProviderID() throws IOException {
		logger.info("unit testing TestMissingPackageProviderID");
		InputStream in = new FileInputStream("src/test/resources/TestMissingPackageProviderID.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Package.ProviderId.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Package.ProviderId.message")));

	}

	@Test
	void testMissingPackageProvider() throws IOException {
		logger.info("unit testing TestMissingPackageProvider");
		InputStream in = new FileInputStream("src/test/resources/TestMissingPackageProvider.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Package.Provider.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Package.Provider.message")));

	}

	@Test
	void testMissingPackagePlatform() throws IOException {
		logger.info("unit testing TestMissingPackagePlatform");
		InputStream in = new FileInputStream("src/test/resources/TestMissingPackagePlatform.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Package.Platform.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Package.Platform.message")));

	}

	@Test
	void testMissingPackageTitle() throws IOException {
		logger.info("unit testing TestMissingPackageTitle");
		InputStream in = new FileInputStream("src/test/resources/TestMissingPackageTitle.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Package.Title.title")));
		assertTrue(body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Package.Title.message")));

	}

	@Test
	void testMissingEligiablePlatform() throws IOException {
		logger.info("unit testing TestMissingEligiablePlatform");
		InputStream in = new FileInputStream("src/test/resources/TestMissingEligiblePlatform.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Platform.EligiblePlatform.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Platform.EligiblePlatform.message")));

	}

	@Test
	void testMissingPlatformWindow() throws IOException {
		logger.info("unit testing TestMissingPlatformWindow");
		InputStream in = new FileInputStream("src/test/resources/TestMissingPlatformWindow.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Platform.Window.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Platform.Window.message")));

	}

	@Test
	void testMissingTitlelicensingWindowStart() throws IOException {
		logger.info("unit testing TestMissingLicensingWindowStart");
		InputStream in = new FileInputStream("src/test/resources/TestMissingLicensingWindowStart.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Title.LicensingWindowStart.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Title.LicensingWindowStart.message")));

	}

	@Test
	void testMissingTitlelicensingWindowEnd() throws IOException {
		logger.info("unit testing TestMissingTitleAsset");
		InputStream in = new FileInputStream("src/test/resources/TestMissingLicensingWindowEnd.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Title.LicensingWindowEnd.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Title.LicensingWindowEnd.message")));

	}

	@Test
	void testMissingTitleAsset() throws IOException {
		logger.info("unit testing TestMissingTitleAsset");
		InputStream in = new FileInputStream("src/test/resources/TestMissingTitleAsset.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Title.Asset.title")));
		assertTrue(body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Title.Asset.message")));

	}

	@Test
	void testMissingAssetClass() throws IOException {
		logger.info("unit testing TestMissingAssetClass");
		InputStream in = new FileInputStream("src/test/resources/TestMissingAssetClass.json");

		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Asset.Class.title")));
		assertTrue(body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Asset.Class.message")));

	}

	@Test
	void testInvalidSourceType() throws IOException {
		logger.info("unit testing TestInvalidAudioType");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidSourceType.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.Type.Enum.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Source.Type.Enum.message")));

	}

	@Test
	void testInvalidSourceVideoCodec() throws IOException {
		logger.info("unit testing testInvalidSourceVideoCodec");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidSourceVideoCodec.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.Codec.video.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.Codec.video.Enum.message")));

	}

	@Test
	void testInvalidSourceAudioCodec() throws IOException {
		logger.info("unit testing Test Invalid Source Audio Codec");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidSourceAudioCodec.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.Codec.audio.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.Codec.audio.Enum.message")));

	}

	@Test
	void testInvalidValueForScreenFormate() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidValueForScreenFormate.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.ScreenFormat.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.ScreenFormat.Enum.message")));

	}

	@Test
	void testInvalidSourceVideoQuality() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidSourceVideoQuality.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.VideoQuality.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.VideoQuality.Enum.message")));

	}

	@Test
	void testInvalidValueForVideoQualityResolution() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidValueForVideQualityResultion.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.VideoQualityResolution.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.VideoQualityResolution.Enum.message")));

	}

	@Test
	void testInvalidHDRType() throws IOException {
		logger.info("unit testing testInvalidHDRType");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidHdrTypeVaue.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Source.HdrType.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.HdrType.Enum.message")));

	}

	@Test
	void testInvalidSourceAudioType() throws IOException {
		logger.info("unit testing TestInvalidAudioType");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidSourceAudioType.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Source.AudioType.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Source.AudioType.Enum.message")));

	}

	@Test
	void testInvalidDistributionVideoQuality() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidDistributionVideoQuality.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Distribution.VideoQuality.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Distribution.VideoQuality.Enum.message")));

	}

	@Test
	void testInvalidPlatformEligiblePlatform() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidPlatformEligiblePlatform.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Platform.EligiblePlatform.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Platform.EligiblePlatform.Enum.message")));

	}

	@Test
	void testInvalidAssetClass() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidAssetClass.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Asset.Class.Enum.title")));
		assertTrue(
				body.getErrors().get(0).getMessage().contains(errorMessageLoader.getValue("Asset.Class.Enum.message")));

	}

	/// Title -> profile

	@Test
	void testInvalidTitleProfile() throws IOException {
		logger.info("unit testing Missing Container");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidTitleProfile.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Title.Profile.Enum.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Title.Profile.Enum.message")));

	}

	/// Title -> providerId

	@Test
	void testInvalidTitleProviderId() throws IOException {
		logger.info("unit testing test InvalidTitleProviderId");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidTitleProviderId.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Title.ProviderId.value.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Title.ProviderId.value.message")));

	}

	@Test
	void testInvalidTitleProvider() throws IOException {
		logger.info("unit testing test InvalidTitleProvider");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidTitleProvider.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Title.Provider.value.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Title.Provider.value.message")));

	}

	@Test
	void testInvalidAssetProviderId() throws IOException {
		logger.info("unit testing test InvalidTitleProviderId");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidAssetProviderId.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("Asset.ProviderId.value.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Asset.ProviderId.value.message")));

	}

	@Test
	void testInvalidAssetProvider() throws IOException {
		logger.info("unit testing test InvalidTitleProvider");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidAssetProvider.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(
				body.getErrors().get(0).getTitle().contains(errorMessageLoader.getValue("Asset.Provider.value.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("Asset.Provider.value.message")));

	}

	@Test
	void testInvalidBreakpointDistributorExtRef() throws IOException {
		logger.info("unit testing TestInvalidBreakpointDistributorExtRef");
		InputStream in = new FileInputStream("src/test/resources/TestInvalidBreakpointDistributorExtRef.json");
		org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper> response = (org.springframework.http.ResponseEntity<CreateIngestErrorResponseWrapper>) processor
				.process((in));
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertNotNull(response);
		CreateIngestErrorResponseWrapper body = response.getBody();
		assertNotNull(body);
		assertNotNull(body.getErrors());
		assertTrue(body.getErrors().size() > 0);
		assertTrue(body.getErrors().get(0).getTitle()
				.contains(errorMessageLoader.getValue("BreakPoints.DistributorExtRef.value.title")));
		assertTrue(body.getErrors().get(0).getMessage()
				.contains(errorMessageLoader.getValue("BreakPoints.DistributorExtRef.value.message")));

	}

	@Test
	void testGeneratedUUId() throws Exception {
		logger.info("unit testing test generated fields: uuid");
//		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
//		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
//		CreateIngest ingest = generatedFieldsOutput.getCreateIngest();
//		// Assert the Priority required fields in uuid
//		assertNotNull(generatedFieldsOutput);
//		assertNotNull(ingest.getUuid());
//		assertTrue(ingest.getUuid().length() == 16);

		// Test for random generated value
		InputStream in2 = new FileInputStream("src/test/resources/TestRequiredFileds2.json");
		CreateIngestRequestWrapper generatedFieldsOutput2 = (CreateIngestRequestWrapper) processor.process((in2));
		CreateIngest ingest2 = generatedFieldsOutput2.getCreateIngest();
		// Assert the Priority required fields in uuid
		assertNotNull(generatedFieldsOutput2);
		assertNotNull(ingest2.getUuid());
		assertTrue(ingest2.getUuid().length() == 36);

	}

	@Test
	void testGeneratedBreakpointsAvailable() throws Exception {
		logger.info("unit testing test generated fields: uuid");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		CreateIngest ingest = generatedFieldsOutput.getCreateIngest();
		// Assert the Priority required fields in BreakpointsAvailable
		assertNotNull(generatedFieldsOutput);
		assertNotNull(ingest.isBreakpointsAvailable());
		assertTrue(ingest.isBreakpointsAvailable());

		// Test for random generated value
		InputStream in2 = new FileInputStream("src/test/resources/TestRequiredFileds2.json");
		CreateIngestRequestWrapper generatedFieldsOutput2 = (CreateIngestRequestWrapper) processor.process((in2));
		CreateIngest ingest2 = generatedFieldsOutput2.getCreateIngest();
		// Assert the Priority required fields in BreakpointsAvailable
		assertNotNull(generatedFieldsOutput2);
		assertNotNull(ingest2.isBreakpointsAvailable());
		assertTrue(ingest2.isBreakpointsAvailable());

	}

	@Test
	void testGeneratedCaptionsAvailable() throws Exception {
		logger.info("unit testing test generated fields: uuid");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		CreateIngest ingest = generatedFieldsOutput.getCreateIngest();
		// Assert the Priority required fields in BreakpointsAvailable
		assertNotNull(generatedFieldsOutput);
		assertNotNull(ingest.isCaptionsAvailable());
		assertTrue(ingest.isCaptionsAvailable());
	}

	@Test
	void testGeneratedPackageAssetId() throws Exception {
		logger.info("unit testing test generated fields: PackageAssetId");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			assertNotNull(dist.getPackage());
			assertNotNull(dist.getPackage().getPackageAssetId());
			assertTrue(dist.getPackage().getPackageAssetId().length() == 20);
		}

		// Test for random generated value
		InputStream in2 = new FileInputStream("src/test/resources/TestRequiredFileds2.json");
		CreateIngestRequestWrapper generatedFieldsOutput2 = (CreateIngestRequestWrapper) processor.process((in2));
		// Assert the Priority required fields in uuid
		assertNotNull(generatedFieldsOutput2);
		for (Distribution dist : (generatedFieldsOutput2.getCreateIngest().getDistribution())) {
			assertNotNull(dist.getPackage());
			assertNotNull(dist.getPackage().getPackageAssetId());
			assertTrue(dist.getPackage().getPackageAssetId().length() == 20);
		}
	}

	@Test
	void testGeneratedPackageVersionMajor() throws Exception {
		logger.info("unit testing test generated fields: VersionMajor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			assertNotNull(dist.getPackage());
			assertNotNull(dist.getPackage().getVersionMajor());
			assertTrue(dist.getPackage().getVersionMajor() == 1);
		}
	}

	@Test
	void testGeneratedPackageVersionMinor() throws Exception {
		logger.info("unit testing test generated fields: VersionMinor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			assertNotNull(dist.getPackage());
			assertNotNull(dist.getPackage().getVersionMinor());
			assertTrue(dist.getPackage().getVersionMinor() == 0);
		}
	}

	@Test
	void testGeneratedTitleAssetId() throws Exception {
		logger.info("unit testing test generated fields: VersionMajor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			Title title = dist.getPackage().getTitle();
			assertNotNull(title);
			assertNotNull(title.getTitleAssetId());
			assertTrue(title.getTitleAssetId().length() == 20);
		}

		// Test for random generated value
		InputStream in2 = new FileInputStream("src/test/resources/TestRequiredFileds2.json");
		CreateIngestRequestWrapper generatedFieldsOutput2 = (CreateIngestRequestWrapper) processor.process((in2));
		// Assert the Priority required fields in uuid
		assertNotNull(generatedFieldsOutput2);
		for (Distribution dist : (generatedFieldsOutput2.getCreateIngest().getDistribution())) {
			Title title = dist.getPackage().getTitle();
			assertNotNull(title);
			assertNotNull(title.getTitleAssetId());
			assertTrue(title.getTitleAssetId().length() == 20);
		}
	}

	@Test
	void testGeneratedTitleVersionMajor() throws Exception {
		logger.info("unit testing test generated fields: VersionMajor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			Title title = dist.getPackage().getTitle();
			assertNotNull(title);
			assertNotNull(title.getVersionMajor());
			assertTrue(title.getVersionMajor() == 1);
		}
	}

	@Test
	void testGeneratedTitleVersionMinor() throws Exception {
		logger.info("unit testing test generated fields: VersionMinor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			Title title = dist.getPackage().getTitle();
			assertNotNull(title);
			assertNotNull(title.getVersionMinor());
			assertTrue(title.getVersionMinor() == 0);
		}
	}

	@Test
	void testGeneratedAssetContentAssetId() throws Exception {
		logger.info("unit testing test generated fields: ContentAssetId");
		// Testing for for already generated values
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in CreateIngest
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			for (Asset asset : dist.getPackage().getTitle().getAsset()) {
				assertNotNull(asset);
				assertNotNull(asset.getContentAssetId());
				assertTrue(asset.getContentAssetId().length() == 20);
			}
		}

		// Test for random generated value
		InputStream in2 = new FileInputStream("src/test/resources/TestRequiredFileds2.json");
		CreateIngestRequestWrapper generatedFieldsOutput2 = (CreateIngestRequestWrapper) processor.process((in2));
		// Assert the Priority required fields in ContentAssetId
		assertNotNull(generatedFieldsOutput2);
		for (Distribution dist : (generatedFieldsOutput2.getCreateIngest().getDistribution())) {
			for (Asset asset : dist.getPackage().getTitle().getAsset()) {
				assertNotNull(asset);
				assertNotNull(asset.getContentAssetId());
				assertTrue(asset.getContentAssetId().length() == 20);
			}
		}
	}

	@Test
	void testGeneratedAssetVersionMajor() throws Exception {
		logger.info("unit testing test generated fields: VersionMajor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in Asset
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			for (Asset asset : dist.getPackage().getTitle().getAsset()) {
				assertNotNull(asset);
				assertNotNull(asset.getVersionMajor());
				assertTrue(asset.getVersionMajor() == 1);
			}
		}
	}

	@Test
	void testGeneratedAssetVersionMinor() throws Exception {
		logger.info("unit testing test generated fields: VersionMinor");
		InputStream in = new FileInputStream("src/test/resources/TestRequiredFileds.json");
		CreateIngestRequestWrapper generatedFieldsOutput = (CreateIngestRequestWrapper) processor.process((in));
		// Assert the Priority required fields in VersionMinor
		assertNotNull(generatedFieldsOutput);
		for (Distribution dist : (generatedFieldsOutput.getCreateIngest().getDistribution())) {
			for (Asset asset : dist.getPackage().getTitle().getAsset()) {
				assertNotNull(asset);
				assertNotNull(asset.getVersionMinor());
				assertTrue(asset.getVersionMinor() == 0);
			}
		}
	}

}
