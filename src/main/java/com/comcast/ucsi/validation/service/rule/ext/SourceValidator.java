package com.comcast.ucsi.validation.service.rule.ext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comcast.ucsi.validation.service.model.Source;
import com.comcast.ucsi.validation.service.model.ValidationRuleResult;

/**
 * Validator for Source Object
 *
 * @author Tarek Shalaby
 *
 */
public class SourceValidator extends Validator<Source> {

	private static Log logger = LogFactory.getLog(SourceValidator.class);

	enum VideoQuality {
		SD, HD, UHD
	};

	public SourceValidator(Source t, Object parent) {
		super(t, parent);

	}

	@Override
	public List<ValidationRuleResult> doValiadtion() {

		List<ValidationRuleResult> result = new ArrayList<ValidationRuleResult>();
		logger.info("doing Valiadtion by a worker of : " + this.getClass().getSimpleName());

		if ((vladatee.getType().equalsIgnoreCase("video"))
				&& (vladatee.getFileLocator() == null || "".equals(vladatee.getFileLocator().trim()))
				&& (vladatee.getFileName() == null || "".equals(vladatee.getFileName().trim()))) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".FileLocator");

		}

		if (vladatee.getType() == null || "".equals(vladatee.getType().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".Type");

		} else {

			if (!vladatee.getType().equalsIgnoreCase("video") && !vladatee.getType().equalsIgnoreCase("audio")
					&& !vladatee.getType().equalsIgnoreCase("closedCaption")
					&& !vladatee.getType().equalsIgnoreCase("subtitle")) {

				return addValidationError(result, vladatee.getClass().getSimpleName() + ".Type" + ".Enum");

			}

		}
		if (vladatee.getType().equalsIgnoreCase("video") || vladatee.getType().equalsIgnoreCase("audio")) {
			if (vladatee.getCodec() == null || "".equals(vladatee.getCodec().trim())) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".Codec");
			} else {

				if (vladatee.getType().equalsIgnoreCase("video") && !vladatee.getCodec().equalsIgnoreCase("IMX50")
						&& !vladatee.getCodec().equalsIgnoreCase("DVCPRO100")
						&& !vladatee.getCodec().equalsIgnoreCase("AVCI")
						&& !vladatee.getCodec().equalsIgnoreCase("H.264")
						&& !vladatee.getCodec().equalsIgnoreCase("H.265")
						&& !vladatee.getCodec().equalsIgnoreCase("WMV")) {
					return addValidationError(result,
							vladatee.getClass().getSimpleName() + ".Codec" + ".video" + ".Enum");

				}

				if (vladatee.getType().equalsIgnoreCase("audio") && !vladatee.getCodec().equalsIgnoreCase("AC3")
						&& !vladatee.getCodec().equalsIgnoreCase("EAC3") && !vladatee.getCodec().equalsIgnoreCase("WAV")
						&& !vladatee.getCodec().equalsIgnoreCase("DOLBYE")
						&& !vladatee.getCodec().equalsIgnoreCase("MP3") && !vladatee.getCodec().equalsIgnoreCase("PCM")
						&& !vladatee.getCodec().equalsIgnoreCase("WMA9") && !vladatee.getCodec().equalsIgnoreCase("AAC")
						&& !vladatee.getCodec().equalsIgnoreCase("FLAC")
						&& !vladatee.getCodec().equalsIgnoreCase("OGG")) {

					return addValidationError(result,
							vladatee.getClass().getSimpleName() + ".Codec" + ".audio" + ".Enum");

				}
			}
		}

		if (vladatee.getDuration() == null && !(vladatee.getType() == null || "".equals(vladatee.getType().trim()))
				&& (vladatee.getType().equalsIgnoreCase("video") || vladatee.getType().equalsIgnoreCase("audio"))) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".Duration");

		} else {
			// ToDO the format should Runtime in ms
		}

		if ((vladatee.getType() != null && !("".equals(vladatee.getType().trim())))
				&& (vladatee.getType().equalsIgnoreCase("video"))) {
			if (vladatee.getContainer() == null || "".equals(vladatee.getContainer().trim())) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".Container");
			} else {
				// ToDO the format should File format container
			}

		}

		if (vladatee.getType() != null && !"".equals(vladatee.getType().trim())
				&& (vladatee.getType().equalsIgnoreCase("video"))) {
			if (vladatee.getScreenFormat() == null || "".equals(vladatee.getScreenFormat().trim())) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".ScreenFormat");
			} else {

				if (!"16:9".equals(vladatee.getScreenFormat()) && !"4:3".equals(vladatee.getScreenFormat())) {

					return addValidationError(result, vladatee.getClass().getSimpleName() + ".ScreenFormat" + ".Enum");

				}

			}

		}

		if (vladatee.getType() != null && !("".equals(vladatee.getType().trim()))
				&& (vladatee.getType().equalsIgnoreCase("video"))) {
			if (vladatee.getVideoQuality() == null || "".equals(vladatee.getVideoQuality().trim())) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".VideoQuality");
			} else {
				if (!VideoQuality.SD.name().equalsIgnoreCase(vladatee.getVideoQuality())
						&& !VideoQuality.HD.name().equalsIgnoreCase(vladatee.getVideoQuality())
						&& !VideoQuality.UHD.name().equalsIgnoreCase(vladatee.getVideoQuality())) {

					return addValidationError(result, vladatee.getClass().getSimpleName() + ".VideoQuality" + ".Enum");

				}
			}

		}

		if ((vladatee.getType() != null && !("".equals(vladatee.getType().trim())))
				&& (vladatee.getType().equalsIgnoreCase("video"))) {
			if (vladatee.getVideoQualityResolution() == null
					|| "".equals(vladatee.getVideoQualityResolution().trim())) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".VideoQualityResolution");
			} else {

				if (!("480i".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("480p".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("720i".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("720p".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("1080i".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("1080p".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("2160p".equalsIgnoreCase(vladatee.getVideoQualityResolution()))
						&& !("4320p".equalsIgnoreCase(vladatee.getVideoQualityResolution()))) {

					return addValidationError(result,
							vladatee.getClass().getSimpleName() + ".VideoQualityResolution" + ".Enum");
				}

			}

		}

		if ((vladatee.getType() != null && !("".equals(vladatee.getType().trim())))
				&& (vladatee.getType().equalsIgnoreCase("video")) && (vladatee.getVideoQuality() != null
						&& VideoQuality.UHD.name().equalsIgnoreCase(vladatee.getVideoQuality().trim()))) {

			// ToDo HDR check type is Video & Video Quality UHD so HDR is required
			if (vladatee.getHdr() == null) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".Hdr");
			} else {

				if (vladatee.getHdrType() == null) {
					return addValidationError(result, vladatee.getClass().getSimpleName() + ".HdrType");
				} else {

					// ToDo Check if the Enum: "HDR10" "DolbyVision" "HLG"
					if (!vladatee.getHdrType().equalsIgnoreCase("HDR10")
							&& !vladatee.getHdrType().equalsIgnoreCase("DolbyVision")
							&& !vladatee.getHdrType().equalsIgnoreCase("HLG")) {
						return addValidationError(result, vladatee.getClass().getSimpleName() + ".HdrType" + ".Enum");
					}
				}
			}

		}

		if ((vladatee.getFramerate() == null) && (vladatee.getType() != null || !("".equals(vladatee.getType().trim())))
				&& (vladatee.getType().equalsIgnoreCase("video"))) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".Framerate");

		}

		if (vladatee.getLanguage() == null || "".equals(vladatee.getLanguage().trim())) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".Language");

		} else {

			// ToDO check that 2 or 5-digit language/locale
		}

		if ((vladatee.getSequence() == null) && (vladatee.getType() != null && !("".equals(vladatee.getType().trim())))
				&& (vladatee.getType().equalsIgnoreCase("video") || vladatee.getType().equalsIgnoreCase("audio")
						|| vladatee.getType().equalsIgnoreCase("closedCaption")
						|| vladatee.getType().equalsIgnoreCase("subtitle"))) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".Sequence");

		}

		if ((vladatee.getType() != null && !"".equals(vladatee.getType().trim()))
				&& ("video".equalsIgnoreCase(vladatee.getType()) || "audio".equalsIgnoreCase(vladatee.getType()))) {

			if ((vladatee.getSegmentInfo() == null)) {
				return addValidationError(result, vladatee.getClass().getSimpleName() + ".SegmentInfo");

			}
		}

		if ((vladatee.getEmbedded() == null) && (vladatee.getType() != null && !"".equals(vladatee.getType().trim()))
				&& ("closedCaption".equalsIgnoreCase(vladatee.getType())
						|| "audio".equalsIgnoreCase(vladatee.getType()))) {
			return addValidationError(result, vladatee.getClass().getSimpleName() + ".Embedded");

		}

		if (vladatee.getType() != null && !("".equals(vladatee.getType().trim()))
				&& vladatee.getType().equalsIgnoreCase("audio")) {
			if ((vladatee.getAudioType() == null || "".equals(vladatee.getAudioType().trim()))) {

				return addValidationError(result, vladatee.getClass().getSimpleName() + ".AudioType");
			} else {

				if (!("Stereo".equalsIgnoreCase(vladatee.getAudioType()))
						&& !("Mono".equalsIgnoreCase(vladatee.getAudioType()))
						&& !("Dolby Digital".equalsIgnoreCase(vladatee.getAudioType()))
						&& !("Dolby 5.1".equalsIgnoreCase(vladatee.getAudioType()))
						&& !("ATMOS".equalsIgnoreCase(vladatee.getAudioType()))) {

					return addValidationError(result, vladatee.getClass().getSimpleName() + ".AudioType" + ".Enum");
				}

			}
		}

		if ((vladatee.getClosedCaptionFormat() == null || "".equals(vladatee.getClosedCaptionFormat().trim()))
				&& (vladatee.getType() != null && !("".equals(vladatee.getType().trim())))
				&& "closedCaption".equalsIgnoreCase(vladatee.getType())) {
			return this.addValidationError(result, vladatee.getClass().getSimpleName() + ".ClosedCaptionFormat");

		}

		return result;
	}

}
