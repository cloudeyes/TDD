package com.tdd.mocking.support;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.services.sns.model.CreatePlatformApplicationRequest;
import com.amazonaws.services.sns.model.CreatePlatformApplicationResult;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.CreatePlatformEndpointResult;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteEndpointRequest;
import com.amazonaws.services.sns.model.DeletePlatformApplicationRequest;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesResult;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.GetPlatformApplicationAttributesResult;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationRequest;
import com.amazonaws.services.sns.model.ListEndpointsByPlatformApplicationResult;
import com.amazonaws.services.sns.model.ListPlatformApplicationsRequest;
import com.amazonaws.services.sns.model.ListPlatformApplicationsResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.services.sns.model.SetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.SetPlatformApplicationAttributesRequest;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import java.util.List;
import java.util.Random;

public class UnstableSNSClient implements AmazonSNS {

  @Override
  public void addPermission(final AddPermissionRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addPermission(
      final String arg0, final String arg1, final List<String> arg2, final List<String> arg3) {
    // TODO Auto-generated method stub

  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(final ConfirmSubscriptionRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(final String arg0, final String arg1) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ConfirmSubscriptionResult confirmSubscription(
      final String arg0, final String arg1, final String arg2) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CreatePlatformApplicationResult createPlatformApplication(
      final CreatePlatformApplicationRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CreatePlatformEndpointResult createPlatformEndpoint(
      final CreatePlatformEndpointRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CreateTopicResult createTopic(final CreateTopicRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CreateTopicResult createTopic(final String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteEndpoint(final DeleteEndpointRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deletePlatformApplication(final DeletePlatformApplicationRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteTopic(final DeleteTopicRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteTopic(final String arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(final AmazonWebServiceRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GetEndpointAttributesResult getEndpointAttributes(
      final GetEndpointAttributesRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GetPlatformApplicationAttributesResult getPlatformApplicationAttributes(
      final GetPlatformApplicationAttributesRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(
      final GetSubscriptionAttributesRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GetSubscriptionAttributesResult getSubscriptionAttributes(final String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(final GetTopicAttributesRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GetTopicAttributesResult getTopicAttributes(final String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListEndpointsByPlatformApplicationResult listEndpointsByPlatformApplication(
      final ListEndpointsByPlatformApplicationRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListPlatformApplicationsResult listPlatformApplications(
      final ListPlatformApplicationsRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(final ListSubscriptionsRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListSubscriptionsResult listSubscriptions(final String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(
      final ListSubscriptionsByTopicRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(final String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListSubscriptionsByTopicResult listSubscriptionsByTopic(
      final String arg0, final String arg1) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListTopicsResult listTopics() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListTopicsResult listTopics(final ListTopicsRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListTopicsResult listTopics(final String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PublishResult publish(final PublishRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PublishResult publish(final String arg0, final String arg1) {
    // TODO Auto-generated method stub
    return null;
  }

  /** This is the only method on the client that we're using for our Stubbing examples. */
  @Override
  public PublishResult publish(final String arg0, final String arg1, final String arg2) {
    final Random r = new Random();
    final int exclusiveUpperBound = 3;
    final int instabilityNumber = r.nextInt(exclusiveUpperBound);

    switch (instabilityNumber) {
      case 0:
        throw new AmazonServiceException("Amazon Service Exception");
      case 1:
        throw new AmazonClientException("Amazon Client Exception");
      case 2:
        return new PublishResult();
      default:
        // Should not hit this case.
        throw new UnsupportedOperationException("Unexpected value returned.");
    }
  }

  @Override
  public void removePermission(final RemovePermissionRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removePermission(final String arg0, final String arg1) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setEndpoint(final String arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setEndpointAttributes(final SetEndpointAttributesRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setPlatformApplicationAttributes(final SetPlatformApplicationAttributesRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setRegion(final Region arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSubscriptionAttributes(final SetSubscriptionAttributesRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setSubscriptionAttributes(final String arg0, final String arg1, final String arg2) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setTopicAttributes(final SetTopicAttributesRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setTopicAttributes(final String arg0, final String arg1, final String arg2) {
    // TODO Auto-generated method stub

  }

  @Override
  public void shutdown() {
    // TODO Auto-generated method stub

  }

  @Override
  public SubscribeResult subscribe(final SubscribeRequest arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SubscribeResult subscribe(final String arg0, final String arg1, final String arg2) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void unsubscribe(final UnsubscribeRequest arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public void unsubscribe(final String arg0) {
    // TODO Auto-generated method stub

  }
}
